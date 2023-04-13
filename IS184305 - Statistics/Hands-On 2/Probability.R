---
title: "Probability"
output:
  html_document:
    theme: cerulean
    highlight: pygments
    css: ../lab.css
---

##Data untuk menjawab soal 

```{r}
download.file("http://www.openintro.org/stat/data/kobe.RData", destfile = "kobe.RData")
load("kobe.RData")
```

```{r}
kobe
```
* * *

## On your own

### Comparing Kobe Bryant to the Independent Shooter

Using `calc_streak`, compute the streak lengths of `sim_basket`.

-   Describe the distribution of streak lengths. What is the typical streak 
    length for this simulated independent shooter with a 45% shooting percentage?
    How long is the player's longest streak of baskets in 133 shots?
Answer:
```{r independent-shooter-with-summary-description}
kobe_streak<-calc_streak(kobe$basket)
table(kobe_streak)

sim_basket <- sample(c("H", "M"), size=133, replace=TRUE, prob=c(0.45, 0.55))
sim_streak <- calc_streak(sim_basket)

table(sim_streak)
barplot(table(sim_streak), col = "lightblue")
summary(calc_streak(sim_basket))
```
Explanation: 
Given the definition of streak length is the number of consecutive baskets made until a miss occurs and looking at the barplot - it shows there are some long streaks but they are very few occurence of those long streaks. The most common streak based on the 133 simulation is 0. The typical streak length for the independent shooter is zero. The simulated streaks lengths are very similar to those of for Kobe.

Overall the barplot indicates:
• The distribution is right skewed (mean is larger than median and mode).
• The typical streak length is 0.
• The longest streak of baskets is length 5.
• the range is from 0 to 5. 
• The typical streak length is 0 based on the mode. 
• The longest streak length is 5.

-   If you were to run the simulation of the independent shooter a second time, 
    how would you expect its streak distribution to compare to the distribution 
    from the question above? Exactly the same? Somewhat similar? Totally 
    different? Explain your reasoning.
Answer: 
I would expect it to be somewhat similar. If we would run the simulation of the independent shooter a second time, results will vary each time we run the simulation, but would be somewhat similar since the shots are independent of each other. The probability of making the shot doesn’t change between the two simulations.
```{r 2nd-simulation-comparison}
sim_basket <- sample(c("H", "M"), size=133, replace=T, prob=c(0.45, 0.55))
sim_streak <- calc_streak(sim_basket)

table(sim_streak)
barplot(table(sim_streak), col = "lightblue")
summary(calc_streak(sim_basket))
```

-   How does Kobe Bryant's distribution of streak lengths compare to the 
    distribution of streak lengths for the simulated shooter? Using this 
    comparison, do you have evidence that the hot hand model fits Kobe's 
    shooting patterns? Explain.
Answer:
```{r}
barplot(table(sim_streak), main = "simulation streak", col = "lightblue")
barplot(table(kobe_streak), main = "kobe streak", col = "lightblue")
```

The distributions appear similar in shape. If the hot hand model were correct for Kobe, we'd expect Kobe's distribution to be more right skewed than the random independent model. This does not appear to be the case. Thus, There is insufficient evidence that the hot hand model fits Kobe’s shooting patterns because the distributions are similar: both modes are 0 and both have the similar ranges.
