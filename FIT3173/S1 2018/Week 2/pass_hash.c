#include <openssl/sha.h>
#include "stdio.h"
#include "string.h"
#include "stdlib.h"

/* The following line shows the definition of SHA1 hash function and its input parameters:

unsigned char *SHA1(const unsigned char *d,     unsigned long n,             unsigned char *md);
                   pointer to data-------^    length in byte--^  pointer to message digest--^
*/


int main() {

  const char * pass="123456";
  
  unsigned char *data,salt[4], digest1[20],digest2[20], *mdptr, *tmpptr;
  unsigned long len;
  int i,j;
  FILE *fp;
  
  len = 4 + strlen(pass);
  /* to read a 32-bit random value as a salt  */
  fp = fopen("/dev/urandom", "r");
  fread(salt, 1, 4, fp);
  fclose(fp);

 /* printing the value of the salt on screen */

  printf("Salt:"); 
  for (i = 0; i < 4; i++) 
     printf("%02x", (unsigned char) *(salt + i));
  printf("\n");

  /* allocating memory with size Salt || password
     in case we change the code and read the password from console or a file etc.
     (then the password length could be variable) */
  data = malloc(len);

  /* cancatinating Salt with password */

  for (i = 0; i < 4; i++)
	data[i] = (unsigned char) *(salt + i); 

  for (i = 4 ; i < len; i++)
	data[i] = *(pass + i);

  /* to check the concatination if you are curios
  printf("\nData:");
  for (i = 0 ; i < len; i++)
	printf("%02x", (unsigned char) *(data + i));
  printf("\n");	
*/


/* calculating the hash(Salt || password)  and printing the result on screen*/
  SHA1( data, len, digest1);
  for (i = 0; i < 20; i++)
	printf("%02x", (unsigned char) *(digest1 + i)); 
  printf("\n");
  free(data); 

/* now we add the iteration as specified in RFC2898 as PBKDF1 
   in each iteration we use the output of previous step as the
   data for the next step (by swaping the pointers to digest1 
   and digest2 buffers.
   After the 10000 iteration we print the result on screen.
*/
  data = digest1;
  mdptr = digest2;
  for (j = 0; j < 10000; j++) {
      SHA1( data, 20, mdptr);
      tmpptr = mdptr;
      mdptr = data;
      data = tmpptr;
  }

  for (i = 0 ; i < 20; i++)
	printf("%02x", (unsigned char) *(data + i));
  printf("\n");	

return 0;
}