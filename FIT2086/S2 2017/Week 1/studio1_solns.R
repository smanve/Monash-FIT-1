####################################################################################
#	Script-file:   studio1_solns.R
#	Project:       FIT2086 - Studio 1
#
# Purpose:  	   Solutions for questions in Studio 1
####################################################################################

# Q4.i Implement a loop that prints out all the odd numbers from 1 to 15.
# Solution 1:
for (i in 1:15)
{
  if (i %% 2 == 1)
  {
    cat(i,"\n")
  }
}

# Solution 2:
for (i in seq(1,15,2))
{
  cat(i,"\n")
}

# Q4.ii Write a function that takes an argument n, calculates the factorial of n, and returns it.
myfactorial <- function(n)
{
  # Error checking -- must be integer >= 0
  if (n < 0 || floor(n) != n)
  {
    stop("n must be non-negative integer")
  }
  # Base-case
  if (n == 0)
  {
    return(1)
  }
  else
  {
    return(n*myfactorial(n-1))
  }
}

1*2*3*4
myfactorial(4)

# Q4.iii
findminmax <- function(x)
{
  # Error checking
  if (!is.numeric(x) || !is.vector(x))
  {
    stop("Input must be a numeric vector")
  }
  
  retval = list()
  retval$min = Inf
  retval$max = -Inf
  for (i in 1:length(x))
  {
    if (x[i] < retval$min)
    {
      retval$min = x[i]
    }
    if (x[i] > retval$max)
    {
      retval$max = x[i]
    }
  }
  
  return(retval)
}
findminmax(c(4,3,10,33,-2,8))

# Q8.i
wine <- read.csv("wine.csv")
wine_corr = c()
for (i in 1:11)
{
  wine_corr[i] = cor(wine[,i], wine$quality)
  cat("Correlation between", names(wine)[i], "and quality = ", wine_corr[i], "\n")
}

cat("Variable with maximum correlation is:", names(wine)[which.max(abs(wine_corr))], "\n")
