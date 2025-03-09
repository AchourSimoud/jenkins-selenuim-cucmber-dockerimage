@panier
Feature: Panier

    Background: 
        Given je suis sur la page produits

    Scenario: ajouter les produits aux panier
        When je click sur les boutons add to cart
        And je click sur le panier
        Then je retrouve tous les produits dans le panier
    
    Scenario: valider les achat
        When je click sur les boutons add to cart
        And je click sur le panier
        And je click sur le bouton checkout
        Then je suis redirige vers la page "https://www.saucedemo.com/checkout-step-one.html"

    Scenario: ne pas continuer si aucun article est ajoute
        And je click sur le panier
        And je click sur le bouton checkout
        Then je ne suis pas redirige vers la page "https://www.saucedemo.com/checkout-step-one.html"

    
        