@checkoutoverview
Feature: checkoutOverview

    Background: 
        Given je suis sur la page produits
        And je click sur les boutons add to cart
        And je click sur le panier
        And je click sur le bouton checkout
        And je saisi le first name "first"
        And je saisi le last name "last"
        And je saisi le code postal "100"
        And je click sur le bouton continue    
    
    Scenario: calcul du totale hors tax
        Then le totale hors taxe affiche est egal a "129.94"

    Scenario: calcul du totale TTC
        Then le totale ttc affiche est egal a "140.34"

    Scenario: finaliser la commande
        When je click sur le bouton finish
        Then je suis redirige vers la page de remerciement "https://www.saucedemo.com/checkout-complete.html"


