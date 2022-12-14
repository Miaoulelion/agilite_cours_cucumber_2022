#Author: Nicolas-Anis
Feature: Ajout et suppression de satellites autour d-une planete
  
  En tant que scientifique, je veux pouvoir modifier l-environnement d-une planete en ajoutant ou supprimant des satellites,
  afin de simuler le cycle de vie d-une planete

  Scenario Outline: Un nouveau satellite gravite autour d-une planete
    Given Une <planete> avec une temperature et un diametre standard
    When de l-ajout d-un <satellite>
    Then Le satellite <estEnOrbite> dans la liste de satellite

    Examples: 
      | planete | satellite | estEnOrbite        |
      | terre   | lune      | luneEstEnOrbite    |
      | neptune | triton    | tritonEstEnOrbite  |
      | neptune | nereide   | nereideEstEnOrbite |

  Scenario Outline: Un satellite est sorti de l-orbite d-une planete
    Given Une <planete> avec une temperature et un diametre standard
    When de la suppression d-un <satellite> de l-orbite de la planete <planete>
    Then Le satellite <estEnOrbite> dans la liste de satellite

    Examples: 
      | planete | satellite | estEnOrbite             |
      | terre   | lune      | luneNEstPlusEnOrbite    |
      | neptune | triton    | tritonNEstPlusEnOrbite  |
      | neptune | nereide   | nereideNEstPlusEnOrbite |
