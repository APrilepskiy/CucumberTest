Feature: Find restaurant
  #Позитивный сценарий: выбираем город домододедо и получем меню для домодедово
  Scenario: chose restaurant city
    Given url of restaurant 'https://pizza-sushi.com/'
    Then chose city 'Домодедово'
    And assert that chosen city is 'Домодедово'
  #Негатинвый сценарий: выбираем город домодедово и пытаемся авторизоваться не пройдя капчу
  Scenario:
    Given url of restaurant 'https://pizza-sushi.com/'
    Then chose city 'Домодедово'
    Then chose element enter
    Then enter login '9999999999'
    Then enter password 'test'
    And assertThatUserGotMessageWrongPass 'Вы не прошли валидацию капчи'