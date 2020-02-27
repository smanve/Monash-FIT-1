my.k.means <- function(X, k)
{
  # Convert the dataframe to a matrix
  X = as.matrix(X)
  
  q = ncol(X)
  n = nrow(X)
  
  # Create data
  mu = matrix(ncol = k, nrow = q)
  d  = matrix(ncol = k, nrow = n)
  
  # cluster ...
}
