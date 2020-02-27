####################################################################################
#	Script-file:   studio8_solns.R
#	Project:       FIT2086 - Studio 8
#
# Purpose:  	   Solutions for questions in Studio 8
####################################################################################


# ----------------------------------------------------------------------------------
# Question 3
# ----------------------------------------------------------------------------------

rm(list=ls())


# ------------------------------------------------------------------------------------------------------
# 3.1
source("my.prediction.stats.R")

gene.train = read.csv("gene.train.csv", header=T)
gene.test = read.csv("gene.test.csv", header=T)
fullmod=glm(Disease ~ ., data=gene.train, family=binomial)
my.pred.stats(predict(fullmod, gene.test, type="response"), gene.test$Disease)


# ------------------------------------------------------------------------------------------------------
# 3.2
coefficients(summary(fullmod))
pvalues = coefficients(summary(fullmod))[,4]
pvalues < 0.05
sum(pvalues < 0.05)


# ------------------------------------------------------------------------------------------------------
# 3.3
# We have p = 100, alpha = 0.05
# So would expect to see 100 * 0.05 = 5 by chance.


# ------------------------------------------------------------------------------------------------------
# 3.4
sum(pvalues < 0.05/100)


# ------------------------------------------------------------------------------------------------------
# 3.4
fit.ric = step(fullmod, direction="both", k=2*log(ncol(gene.train)-1))
summary(fit.ric)
my.pred.stats(predict(fit.ric, gene.test, type="response"), gene.test$Disease)


# ----------------------------------------------------------------------------------
# Question 4
# ----------------------------------------------------------------------------------

rm(list=ls())
source("wrappers.R")
source("my.prediction.stats.R")
library(glmnet)

pima.train = read.csv("pima.train.csv")
pima.test = read.csv("pima.test.csv")


# ------------------------------------------------------------------------------------------------------
# 4.1
lasso.fit = glmnet.f(DIABETES ~ ., pima.train, family="binomial", lambda = 0)
my.pred.stats(predict.glmnet.f(lasso.fit, pima.test, type="response"), pima.test$DIABETES)

coefficients(lasso.fit)


# ------------------------------------------------------------------------------------------------------
# 4.2
lasso.fit = glmnet.f(DIABETES ~ ., pima.train, family="binomial", lambda = 0.02)
coefficients(lasso.fit)
sum(coefficients(lasso.fit) != 0)

lasso.fit = glmnet.f(DIABETES ~ ., pima.train, family="binomial", lambda = 0.03)
coefficients(lasso.fit)
sum(coefficients(lasso.fit) != 0)

lasso.fit = glmnet.f(DIABETES ~ ., pima.train, family="binomial", lambda = 0.05)
coefficients(lasso.fit)
sum(coefficients(lasso.fit) != 0)


# ------------------------------------------------------------------------------------------------------
# 4.3
lasso.fit = glmnet.f(DIABETES ~ ., pima.train, family="binomial")
plot(lasso.fit)


# ------------------------------------------------------------------------------------------------------
# 4.4
lasso.fit = cv.glmnet.f(DIABETES ~ ., pima.train, family="binomial")
plot(lasso.fit)
min(lasso.fit$cvm)


# ------------------------------------------------------------------------------------------------------
# 4.5
coefficients(lasso.fit)
my.pred.stats(predict.glmnet.f(lasso.fit, pima.test, type="response"), pima.test$DIABETES)


# ------------------------------------------------------------------------------------------------------
# 4.6
fit.bic = step(glm(DIABETES ~ .,pima.train,family="binomial"),k=log(668),direction="both")
my.pred.stats(predict(fit.bic, pima.test, type="response"), pima.test$DIABETES)
summary(fit.bic)
coefficients(lasso.fit)


# ------------------------------------------------------------------------------------------------------
# 4.7
ridge.fit = glmnet.f(DIABETES ~ ., pima.train, family="binomial", lambda = 0.05, alpha=0)
coefficients(ridge.fit)

ridge.fit = glmnet.f(DIABETES ~ ., pima.train, family="binomial", lambda = 0.15, alpha=0)
coefficients(ridge.fit)

ridge.fit = glmnet.f(DIABETES ~ ., pima.train, family="binomial", lambda = 0.5, alpha=0)
coefficients(ridge.fit)


# ------------------------------------------------------------------------------------------------------
# 4.8
ridge.fit = cv.glmnet.f(DIABETES ~ ., pima.train, family="binomial", alpha=0)
coefficients(ridge.fit)
my.pred.stats(predict.glmnet.f(ridge.fit, pima.test, type="response"), pima.test$DIABETES)


# ------------------------------------------------------------------------------------------------------
# 4.9
# Fit a full model using glm()
fullmod = glm(DIABETES ~ . , data=pima.train, family=binomial)
my.pred.stats(predict(fullmod,pima.test,type="response"),pima.test$DIABETES)

# Make a model including all interactions, all logs, all squares and all cubics
f = my.make.formula("DIABETES", pima.train, use.interactions=T, use.logs=T, use.squares=T, use.cubics=T)
fullmod = glm(f, data=pima.train, family=binomial)

# lets have a look at how well this model with many parameters does
my.pred.stats(predict(fullmod,pima.test,type="response"),pima.test$DIABETES)

# Now lets prune the model using BIC (and time stepwise)
ptm <- proc.time()
forward.fit.bic = step(fullmod, direction="both", k=log(668), trace=0)
proc.time() - ptm
# takes ~ 36.8s on my machine (will be different on yours ...)

summary(forward.fit.bic)
my.pred.stats(predict(forward.fit.bic,pima.test,type="response"),pima.test$DIABETES)

# Fit the model using lasso + CV
ptm <- proc.time()
lasso.fit = cv.glmnet.f(f, data=pima.train, family="binomial", nfolds=25)
proc.time() - ptm
# takes ~13.5s on my machine; substantially quicker than stepwise

my.pred.stats(predict.glmnet.f(lasso.fit, pima.test, type="response"), pima.test$DIABETES)
glmnet.tidy.coef(lasso.fit)
# model is a little different, and BIC in this case predicts a bit better
# lasso will not always "win", no method can


# ------------------------------------------------------------------------------------------------------
# 4.10
# (a) Swap training and testing data around
pima.train = read.csv("pima.test.csv")
pima.test = read.csv("pima.train.csv")

fullmod = glm(DIABETES ~ . , data=pima.train, family=binomial)
my.pred.stats(predict(fullmod,pima.test,type="response"),pima.test$DIABETES)
# CA = 0.74, AUC = 0.76

# (b) make a model include all interactions, logs, squares and cubics
f = my.make.formula("DIABETES", pima.train, use.interactions=T, use.logs=T, use.squares=T, use.cubics=T)
fullmod = glm(f, data=pima.train, family=binomial)
length(fullmod$coefficients)  # tells you how many predictors exist, after transformation
my.pred.stats(predict(fullmod,pima.test,type="response"),pima.test$DIABETES)
# CA = 0.62, AUC = 0.61 -- lots of overfitting going on as n is now small


# ------------------------------------------------------------------------------------------------------
# 4.11
# Compare to the model fitted by stepwise + BIC
step.fit.bic = step(fullmod, direction="both", k=log(nrow(pima.train)), trace=0)
summary(step.fit.bic)
my.pred.stats(predict(step.fit.bic,pima.test,type="response"), pima.test$DIABETES)
# CA = 0.67, AUC = 0.62 -- still lots of overfitting going on
# this model includes 19 predictors


# ------------------------------------------------------------------------------------------------------
# 4.12
# Fit use lasso + CV
lasso.fit = cv.glmnet.f(f, data=pima.train, family="binomial", nfolds=25)
plot(lasso.fit)
glmnet.tidy.coef(lasso.fit)
my.pred.stats(predict.glmnet.f(lasso.fit, pima.test, type="response"), pima.test$DIABETES)
# CA = 0.77, AUC = 0.82 
# only contains 5 predictors, does better than the model without any interactions/logs/squares etc.
min(lasso.fit$cvm)

# Fit using ridge + CV
ridge.fit = cv.glmnet.f(f, data=pima.train, family="binomial", alpha=0)
my.pred.stats(predict.glmnet.f(ridge.fit, pima.test, type="response"), pima.test$DIABETES)
# does about as well as model not including any extra predictors but worse than Lasso

# Minimum cross-validation scores from lasso and ridge say we should prefer lasso
min(ridge.fit$cvm)
min(lasso.fit$cvm)
