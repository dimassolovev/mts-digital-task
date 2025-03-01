# Тестовое Задание: Парсер Кинофильмов

## Описание проекта

Этот проект представляет собой парсер информации о фильмах с API [The Movie Database (TMDb)](https://www.themoviedb.org/).
Приложение собирает данные о фильмах и сохраняет их в базе данных PostgreSQL.

## Технологии

Проект разработан на **Spring Boot** и использует следующие технологии:

- **Java** `17`
- **Spring Boot** `3.4.3`
- **Spring Cloud** `2024.0.0`
- **Spring Data JPA**
- **PostgreSQL**
- **Liquibase**
- **MapStruct** `1.6.0`
- **OpenFeign**
- **Lombok**

## Функционал

- Запрос данных о фильмах из TMDb API
- Обработка полученных данных
- Сохранение данных в PostgreSQL
- API для получения информации о фильмах из базы данных

## Установка и запуск

### 1. Настройка окружения

Перед запуском убедитесь, что у вас установлен **PostgreSQL** и заданы переменные окружения:

```properties
API_KEY=your_themoviedb_api_key
POSTGRES_URL=jdbc:postgresql://host.docker.internal:5432/films-db
POSTGRES_DB=films-db
POSTGRES_USERNAME=postgres
POSTGRES_PASSWORD=postgres
```

### 2. Клонирование репозитория

```sh
git clone https://github.com/dimassolovev/mts-digital-task
cd mts-digital-task
```

### 3. Сборка приложения

```sh
mvn clean package -DskipTests
```

### 4. Запуск приложения с Docker Compose

```sh
docker-compose up -d
```

## Использование API

### Получение фильма по ID

```sh
curl --location 'http://localhost:8082/films/111'
```

#### Пример ответа:
```json
{
  "budget": 25000000,
  "original_title": "Scarface",
  "title": "Scarface",
  "release_date": "1983-12-09",
  "vote_average": 8.2,
  "movie_db_id": 111,
  "vote_count": 12042,
  "genre_list": [
    { "name": "Action" },
    { "name": "Crime" },
    { "name": "Drama" }
  ]
}
```

### Получение списка фильмов (страница 3, 10 элементов на странице)

```sh
curl --location 'http://localhost:8082/films/list?page=3&size=10'
```

#### Пример ответа:
```json
{
  "content": [
    {
      "budget": 29000000,
      "original_title": "Twelve Monkeys",
      "title": "Twelve Monkeys",
      "release_date": "1995-12-29",
      "vote_average": 7.599,
      "movie_db_id": 63,
      "vote_count": 8465,
      "genre_list": [
        {
          "name": "Mystery"
        },
        {
          "name": "Science Fiction"
        },
        {
          "name": "Thriller"
        }
      ]
    },
    {
      "budget": null,
      "original_title": "Hable con ella",
      "title": "Talk to Her",
      "release_date": "2002-03-15",
      "vote_average": 7.582,
      "movie_db_id": 64,
      "vote_count": 1316,
      "genre_list": [
        {
          "name": "Drama"
        },
        {
          "name": "Romance"
        }
      ]
    },
    {
      "budget": 41000000,
      "original_title": "8 Mile",
      "title": "8 Mile",
      "release_date": "2002-11-08",
      "vote_average": 7.137,
      "movie_db_id": 65,
      "vote_count": 7358,
      "genre_list": [
        {
          "name": "Drama"
        },
        {
          "name": "Music"
        }
      ]
    },
    {
      "budget": 50000000,
      "original_title": "Absolute Power",
      "title": "Absolute Power",
      "release_date": "1997-02-14",
      "vote_average": 6.6,
      "movie_db_id": 66,
      "vote_count": 1110,
      "genre_list": [
        {
          "name": "Action"
        },
        {
          "name": "Crime"
        },
        {
          "name": "Drama"
        }
      ]
    },
    {
      "budget": 2000000,
      "original_title": "Paradise Now",
      "title": "Paradise Now",
      "release_date": "2005-09-07",
      "vote_average": 6.9,
      "movie_db_id": 67,
      "vote_count": 261,
      "genre_list": [
        {
          "name": "Crime"
        },
        {
          "name": "Drama"
        },
        {
          "name": "Thriller"
        },
        {
          "name": "War"
        }
      ]
    },
    {
      "budget": 15000000,
      "original_title": "Brazil",
      "title": "Brazil",
      "release_date": "1985-02-20",
      "vote_average": 7.7,
      "movie_db_id": 68,
      "vote_count": 3352,
      "genre_list": [
        {
          "name": "Comedy"
        },
        {
          "name": "Science Fiction"
        }
      ]
    },
    {
      "budget": 28000000,
      "original_title": "Walk the Line",
      "title": "Walk the Line",
      "release_date": "2005-09-13",
      "vote_average": 7.5,
      "movie_db_id": 69,
      "vote_count": 2912,
      "genre_list": [
        {
          "name": "Drama"
        },
        {
          "name": "Music"
        },
        {
          "name": "Romance"
        }
      ]
    },
    {
      "budget": 30000000,
      "original_title": "Million Dollar Baby",
      "title": "Million Dollar Baby",
      "release_date": "2004-12-15",
      "vote_average": 8.0,
      "movie_db_id": 70,
      "vote_count": 9704,
      "genre_list": [
        {
          "name": "Drama"
        }
      ]
    },
    {
      "budget": 5000000,
      "original_title": "Billy Elliot",
      "title": "Billy Elliot",
      "release_date": "2000-09-28",
      "vote_average": 7.594,
      "movie_db_id": 71,
      "vote_count": 3866,
      "genre_list": [
        {
          "name": "Comedy"
        },
        {
          "name": "Drama"
        },
        {
          "name": "Music"
        }
      ]
    },
    {
      "budget": 20000000,
      "original_title": "American History X",
      "title": "American History X",
      "release_date": "1998-07-01",
      "vote_average": 8.34,
      "movie_db_id": 73,
      "vote_count": 11729,
      "genre_list": [
        {
          "name": "Drama"
        }
      ]
    }
  ],
  "pageable": {
    "pageNumber": 3,
    "pageSize": 10,
    "sort": [],
    "offset": 30,
    "paged": true,
    "unpaged": false
  },
  "last": false,
  "totalPages": 228,
  "totalElements": 2280,
  "first": false,
  "size": 10,
  "number": 3,
  "sort": [],
  "numberOfElements": 10,
  "empty": false
}
```

