####################################################################################
#	Script-file:   studio2_skel.R
#	Project:       FIT2086 - Studio 2
#
# Purpose:  	   Skeleton for questions in Studio 2
####################################################################################

# Q6.1 Weak Law of Large Numbers

# Q6.1.1 Running mean
runningmean <- function(x)
{
  mu = vector(mode = "numeric", length = length(x))
  
  ## Insert code to compute running mean here ...
  # ...

  return(mu)
}

# Generate data and plot
plot(1:1000,runningmean(rnorm(1000,0,1)), type="l", col="red")
# Use "lines" to add new lines to an existing plot ...
lines(1:1000, runningmean(rnorm(1000,0,1)), col = "green")
lines(1:1000, runningmean(rnorm(1000,0,1)), col = "blue")

# Do the same for binomial data -- you should use the ylim=c(0,1) option 
# to set the yaxis to be from 0 to 1 (i.e. the complete parameter space of the binomial)
plot(1:1000, runningmean(rbinom(1000,1,0.5)), type="l", col="red", ylim=c(0,1))
lines(1:1000, runningmean(rbinom(1000,1,0.9)), type="l", col="blue", ylim=c(0,1))



# Q6.2 Estimating probabilities of complex events
count = 0
niterations = 1e3
for (i in 1:niterations)
{
  X = rbinom(10, 1, 0.5)
  
  # Check condition, if condition is met, increment count
  # Here is the example for 6.2.1.
  if (X[1] == 1 && X[2] == 0)
  {
    count = count+1
  }
}
cat("Probability is", count/niterations, "\n")

