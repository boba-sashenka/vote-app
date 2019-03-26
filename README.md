# vote-app

Приложение-голосовалка
Написать серверное standalone приложение со следующим функционалом: 
1) создает темы для голосования,
2) Старт голосования с генерацией ссылки для голосования 
3) Закрытие голосования 
4) Отображение статистики (в виде Выбранный пункт - количество)
5) Получение данных о голосовании(по сгенерированной ссылке)
6) Регистрация голоса

С сервером общение посредством REST API, данные в формате Json.

Обязательные технологии: Java8, Spring boot

Система контроля версий: Git

Документация

Запуск приложения:
1) Открыть командную строку внутри папки vote-app
2) mvnw spring-boot:run -pl vote-app-web
3) Приложение запустилось по http://localhost:8080
Остановка приложения:
1) В том же открытом окне командной строки,Ctrl+C, Выбираем y.

Endpoints

[1] Добавление темы для голосования
POST /themes/add
BODY {"name" : "Theme1", "variants" : [{"name" : "variant1"}, {"name" : "variant2"}]}
RESPONSE themeId

[2] Загрузка всех тем
POST /themes/load/all
BODY {}
RESPONSE [
             {
                 "id": 1,
                 "name": "Theme1",
                 "link": null,
                 "closed": true,
                 "variants": [
                     {
                         "id": 1,
                         "name": "variant1"
                     },
                     {
                         "id": 2,
                         "name": "variant2"
                     }
                 ]
             }
         ]


[3] Старт голосования с генерацией ссылки для голосования
POST /themes/start-voting/{themeId}
BODY {}
RESPONSE generated link

[4] Закрытие голосования
/themes/close-voting/{themeId}
BODY {}
RESPONSE -

[5] Загрузка темы голосования по ссылке
/themes/load/{link}
BODY {}
RESPONSE {
             "id": 1,
             "name": "Theme1",
             "link": "5c01e362-7644-42b3-8847-8f1290a29b0b",
             "closed": true,
             "variants": [
                 {
                     "id": 1,
                     "name": "variant1"
                 },
                 {
                     "id": 2,
                     "name": "variant2"
                 }
             ]
         }

[6] Голосовать по ссылке за определенный вариант. Header identity идентифицирует голос.
/themes/vote/{link}/{variantId}
BODY {}
HEADERS identity
RESPONSE -

[7] Отображение статистики
/themes/statistics/load/{link}
BODY {}
RESPONSE {
             "themeName": "Theme1",
             "statistics": [
                 {
                     "key": "variant1",
                     "value": 5
                 },
                 {
                     "key": "variant2",
                     "value": 2
                 }
             ]
         }
