# week 2 tutorial code

# get current working directory
getwd()

# set working directory
# quotation mark is needed
setwd("any folder name")

# basic maths
# type ?Arithmetic for more operations
34 * 3 + 4 # multiplication and addition
x = 99 ^ 2 # power 
print(x) # print value of x on screen
x # same as above

# create a vector 
temp = c(34, 22.4, 12.4, 10.6, 4, 0.5, -10.1)
temp

# some useful commands
length(temp) 
temp[3] # return value at 3rd index
max(temp) 
min(temp)
mean(temp)
sd(temp) 
# type ?sd for details of command 

# create data frame
x = rep(1, 10) # vector
x
y = 1:10 # sequence from 1 to 5 with default difference 1
y
seq(1, 10, by = 1) # another way of defining a sequence
df = data.frame(x, y) # store vectors x and y into data frame df
df 
head(df) # first 5 lines of df
colnames(df) 
dim(df) # dimension of df
df[,1] # first column of df
df[,"x"] # column of df with the column name x
df$x # same as above 

# created a matrix 
# almost all commands for data frame can be used for matrix too
# e.g dim(), colnames(), mtx[,1], head()
mtx = matrix(1:4, nrow = 2, ncol = 2, byrow = TRUE)
mtx
mtx = matrix(1:4, nrow = 2, ncol = 2, byrow = FALSE)
mtx

# created a list
# list is useful when vectors have different length
x = 1:5
y = 1:3
lst = list(x, y)
lst
df = data.frame(x, y)
df # return error

# data visulization
# histogram
# example 1
x = sample(1:10, 100, replace = TRUE) # sample 100 data from sequence 1 to 10 with replacement
hist(x, xlim = c(0, 12), main = "histogram of number frequencies") # histogram of number frequencies

# example 2 
y = rnorm(1000, mean = 0, sd = 1) # sample 1000 data from standard normal 
hist(y, main = "histogram of data from std normal")

# scatter plot
# type is the type of plot, l for line, b for both line and dot, type ?plot for details
x <- c(0.1375,0.250,0.341,0.458,0.725,0.916,1) # some random data
plot(x, type = "b", col = "red") 
y = c(0.1, 0.2, 0.3, 0.4, 0.7, 0.9, 1)
lines(y, type = "l", col = "blue") # add an extra line onto existing plot

# loops in R
# if statement
w <- 3 # same as w = 3
if (w == 5) { # == means 'equal'
  y = 5
} else if (w == 6) { 
  y = 6
} else {
  y = 7
}

# simplified version of if statement
# check x is an even or odd number
x = 5
ifelse(x %% 2 == 0, "x is even", "x is odd") # %% is the modulo

# for loop
v = c() # empty vector v
for (i in 1:5) {
  v = c(v, i) # add i into vector v in each iteration
  print(v)
}

# while loop
i = 1
while (i <= 5) {
  print(i)
  i = i + 1
}

# created function
# example 1
# a simple quadratic function
g = function(x) x ^ 2 + x + 1
g(1)
g(3)

# example 2
x = rnorm(10) # 10 samples from standard normal
f = function(x) {
  z = c(mean(x), sd(x)) # z is a local variable
  # z <<- c(mean(x), sd(x)) # z is a global variable
  return(z)
}
f(x) # call function x with argument x = x 

# some distribution related functions 
rbinom # binomial
rnorm # norm
runif # uniform
rpois # poisson 
rchisq # chi square

# install extra packages, e.g the bnlearn package
install.packages("bnlearn")

# the above command only install packages to your hard drive, you also need
# to use a library command to call this package every time R/RStudio is started
library(bnlearn)




