---
title: 'Inference for numerical data'
---

## North Carolina births

In 2004, the state of North Carolina released a large data set containing 
information on births recorded in this state. This data set is useful to 
researchers studying the relation between habits and practices of expectant 
mothers and the birth of their children. We will work with a random sample of 
observations from this data set.

## Exploratory analysis

Load the `nc` data set into our workspace.

```{r load-data, eval=FALSE}
download.file("http://www.openintro.org/stat/data/nc.RData", destfile = "nc.RData")
load("nc.RData")
```

* * *

## On your own

1)   Calculate a 95% confidence interval for the average length of pregnancies 
(`weeks`) and interpret it in context. Note that since you're doing inference 
on a single population parameter, there is no explanatory variable, so you can 
omit the `x` variable from the function.
\ans : Result shown as 95 % Confidence interval = ( 38.1528 , 38.5165 )
```{r}
inference(y = nc$weeks, 
          est = "mean", 
          type = "ci", 
          null = 0, 
          alternative = "twosided", 
          method = "theoretical",
          order = c("smoker", "nonsmoker"))
```


2)   Calculate a new confidence interval for the same parameter at the 90% 
confidence level. You can change the confidence level by adding a new argument 
to the function: `conflevel = 0.90`.
\ans : Result shown as 90 % Confidence interval = ( 38.182 , 38.4873 )
```{r}
inference(y = nc$weeks, 
          est = "mean", 
          type = "ci", 
          null = 0, 
          alternative = "twosided", 
          method = "theoretical",
          conflevel = 0.90,
          order = c("smoker", "nonsmoker"))
```


3)   Conduct a hypothesis test evaluating whether the average weight gained by 
younger mothers is different than the average weight gained by mature mothers.
\ans : Null Hypothesis <- the average weight of babies has no correlation to which the age of their mother. As we ran the code below, we get the following result:

- Test statistic: Z =  -1.376 
- p-value =  0.1686 

It is concluded that the p-value is greater than the significance level (0.05). As a result, the alternative hypothesis is considered to be weak, and there is insufficient evidence to reject the null hypothesis.
```{r}
inference(y=nc$gained,
          x=nc$mature, 
          est="mean", 
          type="ht", 
          null=0, 
          alternative="twosided", 
          method="theoretical",
          c("younger mom","mature mom"))
```


4)   Now, a non-inference task: Determine the age cutoff for younger and mature 
mothers. Use a method of your choice, and explain how your method works.
\ans : By using the `range` as parameter, we can determine the range between both of the group. On one hand, young moms are characterized between the age of 13 until 34 while in the other hand, mature mom starts at 35 until 50. So the limitation of which a mother is characterized as young ends at 34. Thus the cut-off age is 35.
```{r}
by(nc$mage, 
   nc$mature, 
   range)
```


5)   Pick a pair of numerical and categorical variables and come up with a 
research question evaluating the relationship between these variables. 
Formulate the question in a way that it can be answered using a hypothesis test
and/or a confidence interval. Answer your question using the `inference` 
function, report the statistical results, and also provide an explanation in 
plain language.
\ans : Research question: "is there a correlation between newborn's weight and their mother smoking habit?"

H0 (Null Hypothesis) <- The smoking habit doesn't impact newborn's weight
HA (Alternative Hypothesis) <- Smoking habit impacts newborn's weight

Result:
- Test statistic: Z =  2.359 
- p-value =  0.0184 

It is concluded that the p-value is less than the significance level (0.05). As a result, the alternative hypothesis is considered to be strong and the null hypothesis is rejected.
```{r}
inference(y=nc$weight,
          x=nc$habit, 
          est="mean", 
          type="ht", 
          null=0, 
          alternative="twosided", 
          method="theoretical")
```


