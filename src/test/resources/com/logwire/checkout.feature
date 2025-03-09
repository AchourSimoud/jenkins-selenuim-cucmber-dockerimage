@checkout
Feature: checkout

    Background: 
        Given je suis sur la page produits
        And je click sur les boutons add to cart
        And je click sur le panier
        And je click sur le bouton checkout
    
    Scenario: informations valides
        When je saisi le first name "first"
        And je saisi le last name "last"
        And je saisi le code postal "100"
        And je click sur le bouton continue
        Then je suis redirige sur la page "https://www.saucedemo.com/checkout-step-two.html"

    Scenario Outline: informations invalides
        When je saisi le first name "<firstname>"
        And je saisi le last name "<lastname>"
        And je saisi le code postal "<zipcode>"
        And je click sur le bouton continue
        Then je ne suis pas redirige sur la page "https://www.saucedemo.com/checkout-step-two.html"

        Examples:
        |firstname|lastname|zipcode|
        ||jean|200|
        |jean||200|
        |jean|jean||
        ||||

        Scenario: fomulaire rempli avec des espace 
        When je saisi le first name " "
        And je saisi le last name " "
        And je saisi le code postal " "
        And je click sur le bouton continue
        Then je ne suis pas redirige sur la page1 "https://www.saucedemo.com/checkout-step-two.html"

      
    
        