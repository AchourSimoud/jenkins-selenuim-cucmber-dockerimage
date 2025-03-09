@produits
Feature: Produits
  Background:
    Given je suis sur la page produits

  Scenario: Verification de la liste des produits
    Then la liste des produits est remplie

  Scenario: verification de l ajout des produits
    When je click sur les boutons add to cart
    Then les boutons remove apparaissent

  Scenario: retrait des produits
    When je click sur les boutons add to cart
    And je click sur les bouton remove
    Then les boutons remove disparaissent


  Scenario Outline: ordonner les produits
    When je trie les produits par "<filtre>"
    Then la liste est ordonnee par "<filtre>"

    Examples:
    |filtre|
    |Name (A to Z)|
    |Name (Z to A)|
    |Price (low to high)|
    |Price (high to low)|
    


  

