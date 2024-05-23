Feature: Automatizacion de REST API - PUT
  Yo como estudiante de calidad de software
  necesito modificar un usuario existente en la API
  para aprender a automatizar servicios

  Scenario: Modificar un usuario con el método PUT
    Given se establece la base url "https://gorest.co.in/"
    When consulta en endpoint "public/v2/users/" por id "6920253" y se modifica el nombre "Yurayny T" y email "yura12@gmail.com"
    Then se valida que el status code sea 200 y que contenga el nombre "Yurayny T" y email "yura12@gmail.com"
