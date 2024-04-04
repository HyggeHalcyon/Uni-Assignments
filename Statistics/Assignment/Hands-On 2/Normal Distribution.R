---
title   : "Tugas Praktikum 2_Normal Distribution"
author  : "Statistika C"
date    : ".........."
output  : html_document
---

##Data untuk menjawab soal 

```{r load-data, eval=FALSE}
download.file("http://www.openintro.org/stat/data/bdims.RData", destfile = "bdims.RData")
load("bdims.RData")
```

```{r}
bdims

mdims <- subset(bdims, sex == 1)
fdims <- subset(bdims, sex == 0)
```

* * *

## On Your Own

-   Now let's consider some of the other variables in the body dimensions dataset.  Using the figures at the end of the exercises, match the histogram to its normal probability plot.  All of the variables have been standardized (first subtract the mean, then divide by the standard deviation), so the units won't be of any help.  If you are uncertain based on these figures, generate the plots in R to check.

    **a.** The histogram for female biiliac (pelvic) diameter (`bii.di`) belongs to normal probability plot letter letter B.
```{r}
qqnorm(fdims$bii.di, main = "Normal QQ plot B")
qqline(fdims$bii.di)

fbii.dimean <- mean(fdims$bii.di)
fbii.disd   <- sd(fdims$bii.di)

hist(fdims$bii.di, main = "Histogram for female biiliac (pelvic) diameter", xlab = "diameter", col = "lightblue")

hist(fdims$bii.di, probability= TRUE,  ylim = c(0, 0.2), xlim = c(15, 35), col = 'lightblue')
x <- 0 : 200
y <- dnorm(x = x, mean = fbii.dimean, sd = fbii.disd)
lines(x=x, 
      y=y, 
      col = "red")

```


    **b.** The histogram for female elbow diameter (`elb.di`) belongs to normal  probability plot letter letter C.
```{r}
qqnorm(fdims$elb.di, main = "Normal QQ plot C")
qqline(fdims$elb.di)

felb.dimean <- mean(fdims$elb.di)
felb.disd   <- sd(fdims$elb.di)

hist(fdims$elb.di, main = "Histogram for female elbow diameter", xlab = "diameter", col = "lightblue")

hist(fdims$elb.di, probability= TRUE,  ylim = c(0, 0.5), xlim = c(8, 17), col = 'lightblue')
x <- 0 : 200
y <- dnorm(x = x, mean = felb.dimean, sd = felb.disd)
lines(x=x, 
      y=y, 
      col = "red")
```


    **c.** The histogram for general age (`age`) belongs to normal probability  plot letter letter D.
```{r}
qqnorm(fdims$age)
qqline(fdims$age)

fage.dimean <- mean(fdims$age)
fage.disd   <- sd(fdims$age)

hist(fdims$age, main = "Histogram for general age", xlab = "age", col = "lightblue")

hist(fdims$age, probability= TRUE,  ylim = c(0, 0.1), xlim = c(15, 60), col = 'lightblue')
x <- 0 : 200
y <- dnorm(x = x, mean = fage.dimean, sd = fage.disd)
lines(x=x, 
      y=y, 
      col = "red")
```
    

    **d.** The histogram for female chest depth (`che.de`) belongs to normal probability plot letter letter A.
```{r}
qqnorm(fdims$che.de)
qqline(fdims$che.de)

fche.dimean <- mean(fdims$che.de)
fche.disd   <- sd(fdims$che.de)

hist(fdims$che.de, main = "Histogram for female chest depth", xlab = "depth", col = "lightblue")

hist(fdims$che.de, probability= TRUE,  ylim = c(0, 0.3), xlim = c(14, 25), col = 'lightblue')
x <- 0 : 200
y <- dnorm(x = x, mean = fche.dimean, sd = fche.disd)
lines(x=x, 
      y=y, 
      col = "red")
```
    

-   Note that normal probability plots C and D have a slight stepwise pattern. Why do you think this is the case?
Answer: the stepwise pattern is caused by many repeated values within the data that usually occurs within discrete datas. We could take the female `elb.di` for an example, which the value of 12.4 occurs 29 times.
```{r}
sum(fdims$elb.di == 12.4)
```
We could recreate an extreme example of this to give produce an even extreme normal probability plots to give a better understanding towards the stepwise pattern.
```{r}
values <- c(1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4)
qqnorm(values)
```


-   As you can see, normal probability plots can be used both to assess normality and visualize skewness.  Make a normal probability plot for female knee diameter (`kne.di`).  Based on this normal probability plot, is this  variable left skewed, symmetric, or right skewed?  Use a histogram to confirm your findings.
```{r}
qqnorm(fdims$kne.di)
qqline(fdims$kne.di)

hist(fdims$kne.di, main = "Histogram for female knee diameter", xlab = "diameter", col = 'lightblue')

hist(fdims$kne.di, probability= TRUE,  ylim = c(0, 0.4), xlim = c(14, 25), col = 'lightblue')
x <- 0 : 200
y <- dnorm(x = x, mean = mean(fdims$kne.di), sd = sd(fdims$kne.di))
lines(x=x, 
      y=y, 
      col = "red")
```
Answer: based on the normal probability plot as we can see, that the line and the plotted points doesn't alligned together. This shows that the plot isn't a symmetrical one. So, since the plotted points are appear to bend up and to the left of the normal it indicates that it is a left skewed variable. This is further proven and confirmed by our understanding of the histogram which shows most of the data is under the mean (~20) which to its left according to the histogram.