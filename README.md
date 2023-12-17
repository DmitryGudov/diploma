[![Build status](https://ci.appveyor.com/api/projects/status/74k49wbrunb6mf1w/branch/main?svg=true)](https://ci.appveyor.com/project/DmitryGudov/diploma/branch/main)
[![Build and Test](https://github.com/DmitryGudov/diploma/actions/workflows/gradle.yml/badge.svg?branch=main)](https://github.com/DmitryGudov/diploma/actions/workflows/gradle.yml)
– бейджики для ветки `main` <br>
[![Build status](https://ci.appveyor.com/api/projects/status/ov6y9t2tv132e7j2/branch/master?svg=true)](https://ci.appveyor.com/project/DmitryGudov/diploma-too00/branch/master)
бейджик для ветки `master`

# Перечень документации

1. <a href="https://github.com/DmitryGudov/diploma/blob/main/docs/Task.md" style="font-size: 18px">Задание дипломного
   проекта</a> <br>
2. <a href="https://github.com/DmitryGudov/diploma/blob/main/docs/Plan.md" style="font-size: 18px">План автоматизации
   тестирования</a> <br>
3. <a href="https://github.com/DmitryGudov/diploma/blob/main/docs/Report.md" style="font-size: 18px">Отчет по итогам
   тестирования</a> <br>
4. <a href="https://github.com/DmitryGudov/diploma/blob/main/docs/Summary.md" style="font-size: 18px">Отчет по итогам
   автоматизации</a> <br>

# Процедура запуска автотестов

## Примечание

Содержимое веток одинаково, есть только одно отличие в файле `application.properties`.

Содержимое файла `application.properties` для ветки `main`, в которой настроена работа `MySQL`:

```
spring.credit-gate.url=http://localhost:9999/credit
spring.payment-gate.url=http://localhost:9999/payment
spring.datasource.url=jdbc:mysql://localhost:3306/app
#spring.datasource.url=jdbc:postgresql://localhost:5432/app
spring.datasource.username=app
spring.datasource.password=pass
```

Содержимое файла `application.properties` для ветки `master`, в которой настроена работа `PostgreSQL`:

```
spring.credit-gate.url=http://localhost:9999/credit
spring.payment-gate.url=http://localhost:9999/payment
#spring.datasource.url=jdbc:mysql://localhost:3306/app
spring.datasource.url=jdbc:postgresql://localhost:5432/app
spring.datasource.username=app
spring.datasource.password=pass
```

## Шаг 1

Открыть консоль с помощью сочетания клавиш `Ctrl + Alt + T` и перейти в директорию, куда будет клонироваться проект.

## Шаг 2

Необходимо склонировать удаленный репозиторий на свой ПК с помощью следующей команды:

```
git clone git@github.com:DmitryGudov/diploma.git
```

## Шаг 3

Находясь в директории склонированого проекта `user@localhost:~/diploma`, необходимо запустить контейнеры в `Docker` с
помощью команды:

```
docker-compose up --build
```

## Шаг 4

1. Если необходимо запустить поддержку `MySQL`, то этот шаг можно пропустить и перейти к следующему.
2. Если необходимо запустить поддержку `PostgreSQL`, то необходимо открыть новое окно в `Terminal` и переключиться на
   ветку `master`.

```
# Используя git checkout (для версий Git до 2.23)
git checkout master
```

```
# Используя git switch (для версий Git 2.23 и выше)
git switch master
```

```
# Для того, чтобы узнать версию Git
git --version
```

## Шаг 5

В новом окне `Terminal` запускаем `aqa-shop.jar` из директории `user@localhost:~/diploma` с помощью команды:

```
java -jar ./artifacts/aqa-shop.jar
```

## Шаг 6

В новом окне `Terminal` запускаем тесты командой:

```
./gradlew test --info -Dselenide.headless=true
```

## Важно!

**Не следует закрывать открытые в `Terminal`  окна до завершения работы с сервисом.**
