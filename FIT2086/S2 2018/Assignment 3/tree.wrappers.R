learn.tree.cv <- function(base_tree, nfolds, m)
{
  # Compute CV scores
  cv <- cv.tree(object=base_tree, FUN=prune.tree, K=nfolds)
  for(i in 2:m)
  {
    cv$dev <- cv$dev + cv.tree(object = base_tree, FUN=prune.tree, K = nfolds)$dev
  }
  cv$dev <- cv$dev/m
  
  # Prune tree using the best 'cv' model
  k = cv$k[which.min(cv$dev)]
  tree.cv = prune.tree(base_tree, k = k * (1-1e-5))
  
  return(list("best.tree"=tree.cv,"cv"=cv,"best_k"=k))
}