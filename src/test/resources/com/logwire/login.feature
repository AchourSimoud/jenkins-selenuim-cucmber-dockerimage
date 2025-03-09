@login
Feature: Login

    Background: 
        Given je suis sur la page "https://www.saucedemo.com/"

    @positifs
    Scenario Outline: differents usernames valides
        When je saisi le username "<user>"
        And je saisi le password "<pwd>"
        And je clique sur login
        Then je suis rederiger a la page produits
        
        Examples:
        |   user   |   pwd |
        | standard_user  |secret_sauce|
        |problem_user|secret_sauce|
        |performance_glitch_user|secret_sauce|
        |error_user|secret_sauce|
        |visual_user|secret_sauce|

    @negatifs
    Scenario Outline: differents usernames valides
        When je saisi le username "<user>"
        And je saisi le password "<pwd>"
        And je clique sur login
        Then je recoit un message erreur

        Examples:
        |   user   |   pwd |
        | standard_user1  |secret_sauce|
        |standard_user2|secret_sauce1|
