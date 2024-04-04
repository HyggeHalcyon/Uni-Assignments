---
title: 'Foundations for statistical inference - Sampling distributions'
output:
  html_document:
    css: ../lab.css
    highlight: pygments
    theme: cerulean
  pdf_document: default
---

In this lab, we investigate the ways in which the statistics from a random 
sample of data can serve as point estimates for population parameters.  We're 
interested in formulating a *sampling distribution* of our estimate in order 
to learn about the properties of the estimate, such as its distribution.

## The data

We consider real estate data from the city of Ames, Iowa.  The details of 
every real estate transaction in Ames is recorded by the City Assessor's 
office.  Our particular focus for this lab will be all residential home sales 
in Ames between 2006 and 2010.  This collection represents our population of 
interest.  In this lab we would like to learn about these home sales by taking 
smaller samples from the full population.  Let's load the data.

```{r load-data, eval=FALSE}
download.file("http://www.openintro.org/stat/data/ames.RData", destfile = "ames.RData")
load("ames.RData")
```

```{r assign, eval=FALSE}
area <- ames$Gr.Liv.Area
price <- ames$SalePrice
```
* * *
## On your own

So far, we have only focused on estimating the mean living area in homes in 
Ames.  Now you'll try to estimate the mean home price.

-   1) Take a random sample of size 50 from `price`. Using this sample, what is 
    your best point estimate of the population mean?
```{r}
for (i in 1:5){
  price_sample <- sample(price, 50)
  print(mean(price_sample))
}
```
    \Answer: Since the sample is taken random at 50 units. Its best to run it a few times to get its         range, here's the result:
      [1] 174111.1
      [1] 200505.1
      [1] 173443.8
      [1] 180148.3
      [1] 172409.3
    thus it can be estimated that the population mean is between 170000 - 200000. We can further            estimate/assume that the mean is around the number of 185000.
  

-   2) Since you have access to the population, simulate the sampling 
    distribution for $\bar{x}_{price}$ by taking 5000 samples from the 
    population of size 50 and computing 5000 sample means.  Store these means 
    in a vector called `sample_means50`. Plot the data, then describe the 
    shape of this sampling distribution. Based on this sampling distribution, 
    what would you guess the mean home price of the population to be? Finally, 
    calculate and report the population mean.
```{r}
sample_mean50 <- rep(0, 5000)

for(i in 1:5000){
   sampple <- sample(price, 50)
   sample_mean50[i] <- mean(sampple)
}

hist(sample_mean50, breaks = 25)
mean(sample_mean50)
mean(price)
```
    \Answer: The data distribution seems to be fairly normal with a slight skew to the left. Based on the calculation, we retrieve a sample price distribution numbering 180514.7 and a population mean of price numbering 180796.1. It can be concluded that the sample price distribution is normal since its the number is relatively close.

-   3) Change your sample size from 50 to 150, then compute the sampling 
    distribution using the same method as above, and store these means in a 
    new vector called `sample_means150`. Describe the shape of this sampling 
    distribution, and compare it to the sampling distribution for a sample 
    size of 50.  Based on this sampling distribution, what would you guess to 
    be the mean sale price of homes in Ames?
```{r}
sample_mean150 <- rep(0, 5000)

for(i in 1:5000){
   sampple <- sample(price, 150)
   sample_mean50[i] <- mean(sampple)
}

hist(sample_mean50, breaks = 50)
mean(sample_mean50)
mean(price)
```
    \Answer: the new sampling of 150 units appears to be more centered and less skewed to the left(though it still is) but still roughly the same. Since it contains much more sample, we can also see that the data appears to be visual of the data is thinner and much taller. When comparing the mean sample to our previous test with smaller sample, both return a relatively close value, so there's not much of a different. I would guess the sale price of homes in Ames is around 180700.0

-   4) Of the sampling distributions from 2 and 3, which has a smaller spread?  If
    we're concerned with making estimates that are more often close to the 
    true value, would we prefer a distribution with a large or small spread?
    \Answer: The bigger the sample size is, the less spread it has since there's less variability and       the closer it gets to its population(actual) value. Therefore sampling distribution with a small        spread is preferable

<div id="license">
This is a product of OpenIntro that is released under a [Creative Commons 
Attribution-ShareAlike 3.0 Unported](http://creativecommons.org/licenses/by-sa/3.0).
This lab was written for OpenIntro by Andrew Bray and Mine &Ccedil;etinkaya-Rundel.
</div>