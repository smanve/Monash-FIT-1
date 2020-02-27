# Code to generate sampling distributions for maximum likelihood estimate of Poisson rate
# Overlay with normal approximations from CLT
# FIT2086 -- Lecture 4. (c) Daniel F. Schmidt 2018
poiss.sampling.distr <- function(lambda, n, n.iterations)
{
  lambda.hat = rep(0,n.iterations)
  
  # Simulation
  for (i in 1:n.iterations)
  {
    # Generate 'n' samples from a Poi(lambda) distribution
    y = rpois(n, lambda)
    
    # Calculate ML estimate of lambda
    lambda.hat[i] = mean(y)
  }
  
  return(lambda.hat)
}

x = seq(0,10,by=0.01)

# lambda = 5, n = 5
lambda.hat = poiss.sampling.distr(5, 5, 1e6)
mean(lambda.hat)    # Should be essentially equal to 5
var(lambda.hat)     # Should be essentially equal to 1
hist(lambda.hat,probability=T,xlab="ML Estimate of lambda (n=5)",breaks=10)
lines(x, dnorm(x,5,sqrt(5/5)), col="red")

# lambda = 5, n = 25
lambda.hat = poiss.sampling.distr(5, 25, 1e6)
hist(lambda.hat,probability=T,xlab="ML Estimate of lambda (n=25)")
lines(x, dnorm(x,5,sqrt(5/25)), col="red")
