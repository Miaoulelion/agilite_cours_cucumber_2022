#Author: Nicolas

Feature: Cocktail Ordering

  En tant que planète, je veux pouvoir posséder autour de moi un ou plusieurs satellites, afin d-avoir une vie cosmique saine et équilibrée.
  
  Scenario: Un nouveau satellite gravite autour d'une planète  
  Given Une planète avec une température et un diamètre standard
  When  de l-ajout d-un satellite
  Then  there is no cocktail in the order
