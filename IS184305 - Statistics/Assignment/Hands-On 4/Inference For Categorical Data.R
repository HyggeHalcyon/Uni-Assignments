---
title: 'Inference for categorical data'
---

In August of 2012, news outlets ranging from the [Washington
Post](http://www.washingtonpost.com/national/on-faith/poll-shows-atheism-on-the-rise-in-the-us/2012/08/13/90020fd6-e57d-11e1-9739-eef99c5fb285_story.html) to the [Huffington
Post](http://www.huffingtonpost.com/2012/08/14/atheism-rise-religiosity-decline-in-america_n_1777031.html)
ran a story about the rise of atheism in America. The source for the story was 
a poll that asked people, "Irrespective of whether you attend a place of 
worship or not, would you say you are a religious person, not a religious 
person or a convinced atheist?" This type of question, which asks people to 
classify themselves in one way or another, is common in polling and generates 
categorical data. In this lab we take a look at the atheism survey and explore 
what's at play when making inference about population proportions using 
categorical data.

## The survey

To access the press release for the poll, conducted by WIN-Gallup 
International, click on the following link:

*<http://www.wingia.com/web/files/richeditor/filemanager/Global_INDEX_of_Religiosity_and_Atheism_PR__6.pdf>*

Take a moment to review the report then address the following questions.

1.  In the first paragraph, several key findings are reported. Do these 
    percentages appear to be *sample statistics* (derived from the data 
    sample) or *population parameters*?

2.  The title of the report is "Global Index of Religiosity and Atheism". To
    generalize the report's findings to the global human population, what must 
    we assume about the sampling method? Does that seem like a reasonable 
    assumption?

## The data

Turn your attention to Table 6 (pages 15 and 16), which reports the
sample size and response percentages for all 57 countries. While this is
a useful format to summarize the data, we will base our analysis on the
original data set of individual responses to the survey. Load this data
set into R with the following command.

```{r head-data, eval=FALSE}
download.file("http://www.openintro.org/stat/data/atheism.RData", destfile = "atheism.RData")
load("atheism.RData")
```

* * *
## On your own

The question of atheism was asked by WIN-Gallup International in a similar 
survey that was conducted in 2005. (We assume here that sample sizes have 
remained the same.) Table 4 on page 13 of the report summarizes survey results 
from 2005 and 2012 for 39 countries.

1)  Answer the following two questions using the `inference` function. As 
    always, write out the hypotheses for any tests you conduct and outline the
    status of the conditions for inference.

    **a.** Is there convincing evidence that Spain has seen a change in its 
    atheism index between 2005 and 2012?
    *Hint:* Create a new data set for respondents from Spain. Form
    confidence intervals for the true proportion of athiests in both
    years, and determine whether they overlap.
    \ans: 
    HO (Null Hypothesis) <- No substantial changes in atheism in spain between 2005 - 2012
    HA (Alternative Hypothesis) <- There's a substantial changes in atheism in spain between 2005 - 2012
    
    Conclusion: The confidence intervals for both the 2005 and 2012 samples show an overlap, The value of p-Spain12, which is 0.09, is within the confidence interval of the 2005 sample (0.083 - 0.1177). Thus we stand by the Null Hypothesis 
```{r}
spain <- subset(atheism, nationality == "Spain" & (year == "2005" | year == "2012"))
spain05 <- subset(atheism, nationality == "Spain" & year == "2005")
spain12 <- subset(atheism, nationality == "Spain" & year == "2012")

inference(spain$response,
          spain$year,
          alternative="twosided",
          method="theoretical",
          est="proportion",
          type="ci",
          success="atheist",
          null=0)

inference(spain05$response,
          method="theoretical",
          est="proportion",
          type="ci",
          success="atheist")

inference(spain12$response,
          method="theoretical",
          est="proportion",
          type="ci",
          success="atheist")
```
    

    **b.** Is there convincing evidence that the United States has seen a
    change in its atheism index between 2005 and 2012?
    \ans:
    HO (Null Hypothesis) <- No substantial changes in atheism in the US between 2005 - 2012
    HA (Alternative Hypothesis) <- There's a substantial changes in the US in spain between 2005 - 2012
    
    Conclusion: The confidence intervals for both the 2005 and 2012 samples doesn't show any overlap, The value of p-US12, which is 0.0499 does not fall within the confidence interval of the 2005 sample (0.0038 - 0.0161). Thus we reject the Null Hypothesis and stany by the Alternative Hypothesis
```{r}
US <- subset(atheism, nationality == "United States" & (year == "2005" | year == "2012"))
US05 <- subset(atheism, nationality == "United States" & year == "2005")
US12 <- subset(atheism, nationality == "United States" & year == "2012")

inference(US$response,
          US$year,
          alternative="twosided",
          method="theoretical",
          est="proportion",
          type="ci",
          success="atheist",
          null=0)

inference(US05$response,
          method="theoretical",
          est="proportion",
          type="ci",
          success="atheist")

inference(US12$response,
          method="theoretical",
          est="proportion",
          type="ci",
          success="atheist")
```
    

2)  If in fact there has been no change in the atheism index in the countries 
    listed in Table 4, in how many of those countries would you expect to 
    detect a change (at a significance level of 0.05) simply by chance?\
    *Hint:* Look in the textbook index under Type 1 error.
    \ans: If we observe a change in the atheism index despite no real change occurring, and we decide to reject the null hypothesis, it is considered a Type I error. This refers to the incorrect rejection of the Null Hypothesis when it is actually true, which is also known as a Type I mistake. With a sample size of 39 countries and a significance level of 0.05, we can compute the following: `~ 39 * 0.05 = 1.95`. Alternatively, rounding up the result leads to a total of 2 countries of which we can expect to detect a change.
```{r}
numOfCountries <- 39
significant_level <- 0.05
countries <- numOfCountries * significant_level
countries
```
    

3)  Suppose you're hired by the local government to estimate the proportion of 
    residents that attend a religious service on a weekly basis. According to 
    the guidelines, the estimate must have a margin of error no greater than 
    1% with 95% confidence. You have no idea what to expect for $p$. How many 
    people would you have to sample to ensure that you are within the 
    guidelines?\
    *Hint:* Refer to your plot of the relationship between $p$ and margin of 
    error. Do not use the data set to answer this question.
    \ans: To determine the required sample size for ensuring that the sample proportion is within 0.01 of the true proportion at a 95% confidence level, we can utilize the assumption that the maximum margin of error occurs when p is 0.5. Using the formula `ME = z * SE = 1.96 * sqrt(p(1-p)/n))`, where p represents the proportion and n is the sample size, we can estimate the minimum number of participants needed. By applying this approach, it is determined that a minimum of 9604 individuals is required to guarantee that the sample proportions are within 0.01 of the true proportions at a 95% confidence level.
```{r}
z <- 1.96
ME <- 0.01
p <- 0.5
N<- z^2*p*(1-p)/ME^2
N
```
