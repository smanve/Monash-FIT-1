####################################################################################
#	Script-file:   studio2.skel.R
#	Project:       FIT2086 - Studio 2
#
# Purpose:  	   Skeleton for questions in Studio 2
####################################################################################

# Q6 Weak Law of Large Numbers

# Q6.1 Running mean
runningmean <- function(x)
{
  mu = vector(mode = "numeric", length = length(x))
  
  ## Insert code to compute running mean here ...
  # ...

  return(mu)
}

# Q6.2
# Generate data and plot
plot(1:1000,runningmean(rnorm(1000,0,1)), type="l", col="red")

# Use "lines" to add new lines to an existing plot ...
lines(1:1000, runningmean(rnorm(1000,0,1)), col = "green")
lines(1:1000, runningmean(rnorm(1000,0,1)), col = "blue")

# Q6.3
# Do the same for binomial data -- you should use the ylim=c(0,1) option 
# to set the yaxis to be from 0 to 1 (i.e. the complete parameter space of the binomial)
# ...