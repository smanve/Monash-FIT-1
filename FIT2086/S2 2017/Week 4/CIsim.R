testCIknownSigma2 <- function(pop_mu, pop_sigma2, n, niter)
{
  retval = list()
  retval$coverage = 0
  
  # Do niter simulations
  for (i in 1:niter)
  {
    # Generate data from the population
    y = rnorm(n, pop_mu, sqrt(pop_sigma2))
    
    # Compute the 95% confidence interval
    mu_hat = mean(y)
    CI = mu_hat + c(-1.96*sqrt(pop_sigma2)/sqrt(n), 1.96*sqrt(pop_sigma2)/sqrt(n))
    
    # Does it cover the population parameter?
    if (pop_mu >= CI[1] && pop_mu <= CI[2])
    {
      retval$coverage = retval$coverage + 1
    }
  }
  
  # Estimate coverage as proportion of times interval covered the population parameter
  retval$coverage = retval$coverage/niter
  
  return(retval)
}