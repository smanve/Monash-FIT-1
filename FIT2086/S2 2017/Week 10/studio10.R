rm(list=ls())
library("mclust")

# 2.1
data(diabetes)

# 2.2
class = diabetes$class
table(class)

X = diabetes[,-1]

clp <- clPairs(X, class, lower.panel = NULL)
clPairsLegend(0.1, 0.3, class = clp$class, col = clp$col, pch = clp$pch)

# 2.3
mod1 = Mclust(X, modelNames = "VVI")
summary(mod1, parameters = TRUE)
plot(mod1, what = "classification")

table(class, mod1$classification)

# 2.4
BIC <- mclustBIC(X)
BIC

summary(BIC)
plot(BIC)

# 2.5
mod1 = Mclust(X, x = BIC)
summary(mod1, parameters = TRUE)

# 2.6
# How well did we classify?
table(class, mod1$classification)

# Plot classifications
plot(mod1, what = "classification")


# 3.1
diabetes.train = read.csv("diabetes.train.csv")

I = sample(10*354)
V = as.matrix(diabetes.train)
V[I[1:600]] = NA
diabetes.miss = as.data.frame(V)

# 3.2
diabetes.mean = simple.impute(diabetes.miss, "mean")

summary(diabetes.miss)
summary(diabetes.mean)

# 3.3
diabetes.knn = knnImputation(diabetes.miss, k=10)

summary(diabetes.miss)
summary(diabetes.knn)

# 3.4
fit.mean = lm(Y ~ ., data=diabetes.mean)
#fit.mean = step(fit.mean, direction="both")
summary(fit.mean)

fit.knn = lm(Y ~ ., data=diabetes.knn)
#fit.knn = step(fit.knn, direction="both")
summary(fit.knn)

# 3.5
diabetes.test = read.csv("diabetes.test.csv")

mean( (diabetes.test$Y - predict(fit.mean, diabetes.test))^2 )
mean( (diabetes.test$Y - predict(fit.knn, diabetes.test))^2 )


# clp <- clPairs(X.train, lower.panel = NULL)
# clPairsLegend(0.1, 0.3, class = clp$class, col = clp$col, pch = clp$pch)
# 
# BIC <- mclustBIC(X.train)
# 
# summary(BIC)
# plot(BIC)
# 
# # 3.4
# mm = Mclust(X.train, x = BIC)
# summary(mm, parameters = TRUE)
# 
# t = data.frame("Y" = diabetes.train$Y)
# t$mm.class = as.factor(mm$classification)
# fit.mm = lm(Y ~ mm.class, data=t)
# summary(fit.mm)
# 
# 
# #
# diabetes.test = read.csv("diabetes.test.csv")
# X.test = diabetes.test[,-11]
# tst = diabetes.test
# tst$mm.class = as.factor(predict(mm, X.test)$classification)
# 
# mean( (tst$Y - predict(fit.mm,tst))^2)

# # 3
# # 3.1
# pima.train = read.csv("pima.test.csv")
# pima.test = read.csv("pima.train.csv")
# source("my.prediction.stats.R")
# 
# fit = glm(DIABETES ~ ., data=pima.train, family=binomial)
# fit.bic = step(fit, k=log(nrow(pima.train)))
# my.pred.stats(predict(fit.bic, pima.test, type="response"), pima.test$DIABETES)
# 
# # 3.2
# class = pima.train$DIABETES
# X = pima.train[,-9]
# #X = pima.train
# #X[,9] = as.numeric(X[,9])
# 
# clp <- clPairs(X, class, lower.panel = NULL)
# clPairsLegend(0.1, 0.3, class = clp$class, col = clp$col, pch = clp$pch)
# 
# # 3.3
# BIC <- mclustBIC(X)
# 
# summary(BIC)
# plot(BIC)
# 
# # 3.4
# mm = Mclust(X, x = BIC)
# summary(mm, parameters = TRUE)
# 
# table(class, mm$classification)
# 
# # 3.5
# t = data.frame("DIABETES" = pima.train$DIABETES)
# t$mm.class = as.factor(mm$classification)
# fit.mm = glm(DIABETES ~ mm.class, data=t, family=binomial)
# summary(fit.mm)
# 
# pima.test = read.csv("pima.train.csv")
# X.test = pima.test[,-9]
# tst = data.frame("DIABETES" = pima.test$DIABETES)
# tst$mm.class = as.factor(predict(mm, X.test)$classification)
# my.pred.stats(predict(fit.mm, tst, type="response"), pima.test$DIABETES)
# 
# 
# 
# pima.test = read.csv("pima.test.csv")
# X.test = pima.test[,-9]
# X.test[,9] = 1.35479
# pima.test$mm.class = as.factor(predict(mm, X.test)$classification)
# my.pred.stats(predict(fit.mm, pima.test, type="response"), pima.test$DIABETES)
# 
# 
# 
# 
# mod2 = MclustDA(X, class, G=1:10, modelType = "MclustDA")
# my.pred.stats(predict(mod2,pima.test[,-9])$z[,2], pima.test$DIABETES)
