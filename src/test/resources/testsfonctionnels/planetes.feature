#Author: Nicolas

Feature: Cocktail Ordering

  En tant que plan�te, je veux pouvoir poss�der autour de moi un ou plusieurs satellites, afin d-avoir une vie cosmique saine et �quilibr�e.
  
  Scenario: Un nouveau satellite gravite autour d'une plan�te  
  Given Une plan�te avec une temp�rature et un diam�tre standard
  When  de l-ajout d-un satellite
  Then  there is no cocktail in the order
