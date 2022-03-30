Feature: Find restaurant
  #Позитивный сценарий: выбираем город краснодар и получем меню для краснодара
  Scenario: chose restaurant city
    Given url of restaurant 'https://pizza-sushi.com/'
    Then chose city 'Домодедово'
    And assert that chosen city is 'Домодедово'
  #Негатинвый сценарий: выбираем несушествующий город, получаем соответствуещее уведомление
  Scenario:
    Given url of restaurant 'https://pizza-sushi.com/'
    Then chose city 'Домодедово'
    Then chose element enter
    Then enter login '9999999999'
    Then enter password 'test'
    And assertThatUserGotMessageWrongPass 'Вы не прошли валидацию капчи'