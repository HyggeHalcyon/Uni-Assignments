#Nama: 
#NRP: 
#Class: C

import pandas as pd
from scipy import stats as st
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

#importing and formatting dataset
dataset = "\\access_to_water_and_sanitation.csv"
fields = ['Service Type', 'Year', 'Coverage', 'Population', 'Service level']
ds = pd.read_csv(dataset, skipinitialspace=True, usecols=fields)

#Descriptive of "Service Type" variable
def serviceType():
    data = {'appearance': ds['Service Type'].value_counts()}
    print(pd.DataFrame(data))
    print(plt.hist(ds['Service Type'], color='blue', edgecolor='black'))
    plt.xlabel('Service Types')
    plt.ylabel('Appearance')
    plt.title('Appearance of Service Types within the Dataset')

#Descriptive of "Year" variable
def year():
    print(ds['Year'].value_counts())

    year_drinking = ds['Year'].where(ds['Service Type'] == "Drinking water").value_counts()
    year_hygiene = ds['Year'].where(ds['Service Type'] == "Hygiene").value_counts()
    year_sanitation = ds['Year'].where(ds['Service Type'] == "Sanitation").value_counts()

    data = {
        'Year' : ds['Year'].unique(),
        'Drinking water': year_drinking,
        'Hygiene' : year_hygiene,
        'Sanitation' : year_sanitation,
    }

    ds_year = pd.DataFrame(data)
    print(ds_year)
    ds_year[['Year' , 'Drinking water', 'Hygiene', 'Sanitation']].plot(x = 'Year', 
                                                                       title='Modes in accordance to Service Types', 
                                                                       kind='bar')

    print(ds['Year'].median())
    print(ds['Year'].where(ds['Service Type'] == "Drinking water").median())
    print(ds['Year'].where(ds['Service Type'] == "Hygiene").median())
    print(ds['Year'].where(ds['Service Type'] == "Sanitation").median())


    print(ds['Year'].max() - ds['Year'].min())
    print(ds['Year'].where(ds['Service Type'] == "Drinking water").max() - ds['Year'].where(ds['Service Type'] == "Drinking water").min())
    print(ds['Year'].where(ds['Service Type'] == "Hygiene").max() - ds['Year'].where(ds['Service Type'] == "Hygiene").min())
    print(ds['Year'].where(ds['Service Type'] == "Sanitation").max() - ds['Year'].where(ds['Service Type'] == "Sanitation").min())

#Descriptive of "Coverage" variable
def coverage():
    print(ds['Coverage'].mean())
    print(ds['Coverage'].median())
    print(ds['Coverage'].max() - ds['Coverage'].min())
    print(ds['Coverage'].mad())
    print(ds['Coverage'].var())
    print(ds['Coverage'].std())

    #Descriptive of "Population" variable
    print(ds['Population'].mean())
    print(ds['Population'].median())
    print(ds['Population'].max() - ds['Coverage'].min())
    print(ds['Population'].mad())
    print(ds['Population'].var())
    print(ds['Population'].std())

#Descriptive of "Service level" variable
def serviceLevel():
    print(ds['Service level'].value_counts())

    data = {'Drinking water': ds['Service level'].where(ds['Service Type'] == "Drinking water").value_counts()}
    print(pd.DataFrame(data))
    data = {"Hygiene" : ds['Service level'].where(ds['Service Type'] == "Hygiene").value_counts()}
    print(pd.DataFrame(data))
    data = {'Sanitation' : ds['Service level'].where(ds['Service Type'] == "Sanitation").value_counts()}
    print(pd.DataFrame(data))

#Form Analysis
def form_boxplot():
    serviceLevel = ["Drinking water", "Hygiene", "Sanitation"]

    coveragedrink = ds['Coverage'].where(ds['Service Type'] == "Drinking water")
    coveragehygiene = ds['Coverage'].where(ds['Service Type'] == "Hygiene")
    coveragesanitation = ds['Coverage'].where(ds['Service Type'] == "Sanitation")

    populationdrink = ds['Population'].where(ds['Service Type'] == "Drinking water")
    populationhygiene = ds['Population'].where(ds['Service Type'] == "Hygiene")
    populationsanitation = ds['Population'].where(ds['Service Type'] == "Sanitation")

    coveragedrink = 3 * (coveragedrink.mean() - coveragedrink.median()) / coveragedrink.std()
    coveragehygiene = 3 * (coveragehygiene.mean() - coveragehygiene.median()) / coveragehygiene.std()
    coveragesanitation = 3 * (coveragesanitation.mean() - coveragesanitation.median()) / coveragesanitation.std()

    populationdrink = 3 * (populationdrink.mean() - populationdrink.median()) / populationdrink.std()
    populationhygiene = 3 * (populationhygiene.mean() - populationhygiene.median()) / populationhygiene.std()
    populationsanitation = 3 * (populationsanitation.mean() - populationsanitation.median()) / populationsanitation.std()

    skewness = [coveragedrink, coveragehygiene, coveragesanitation, populationdrink, populationhygiene, populationsanitation]
    
    for i in range(0, 3):
        category = serviceLevel[i % 3] 

        if skewness[i] < 0:
            print(str(skewness[i]) + " : Asymmetric - Left Skew - coverage - " + category)
        elif skewness[i] > 0:
            print(str(skewness[i]) + " : Asymmetric - Right Skew - coverage - " + category)
        else:
            print(str(skewness[i]) + " : Symmetric coverage - " + category)

    for i in range(3, 6):
        category = serviceLevel[i % 3]

        if skewness[i] < 0:
            print(str(skewness[i]) + " : Asymmetric - Left Skew - population - " + category)
        elif skewness[i] > 0:
            print(str(skewness[i]) + " : Asymmetric - Right Skew - population - " + category)
        else:
            print(str(skewness[i]) + " : Symmetric population - " + category)

    ds.boxplot(by ='Service Type', column =['Coverage'], grid = False)
    ds.boxplot(by ='Service Type', column =['Population'], grid = False)
