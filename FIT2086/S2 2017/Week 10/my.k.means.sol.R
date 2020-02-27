my.k.means <- function(X, k)
{
  # Convert the dataframe to a matrix
  X = as.matrix(X)
  
  q = ncol(X)
  n = nrow(X)
  
  # Create data
  mu = matrix(ncol = k, nrow = q)
  d  = matrix(ncol = k, nrow = n)
  
  # Initial centroids
  mu = X[sample(n)[1:k], ]
  
  # Cluster ...
  for (i in 1:100)
  {
    # Calculate distances from each cluster
    for (j in 1:k)
    {
      d[,j] = rowSums( (X - mu[j,])^2 )
    }
    
    # Assign points to cluster
    w.cluster = max.col(-d)
    
    # Re-estimate
    for (j in 1:k)
    {
      if (sum(w.cluster == j) > 1)
      {
        mu[j,] = colMeans( X[w.cluster==j,] )
      }
      else if (sum(w.cluster == j) == 1)
      {
        mu[j,] = X[w.cluster==j,]
      }
    }
  }
  
  #
  rv = list()
  rv$mu = mu
  rv$w.cluster = w.cluster
  
  return(rv)
}
