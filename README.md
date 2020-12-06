A program mongoDB-t használ, a localhost:27017 hoston, az autok / auto collectiont.

Webes felületen elérhető:

autók kilistázása,

autó részletes adatok,

adatok módosítása (kivéve rendszám),

adatok törlése


REST API endpointok:

GET: http://localhost:8080/web_war/rest/autok

GET: http://localhost:8080/web_war/rest/autok?uzemanyag={uzemanyag}

GET: http://localhost:8080/web_war/rest/auto/{rendszam}

DELETE: http://localhost:8080/web_war/rest/auto/{rendszam}

POST: http://localhost:8080/web_war/rest/autok (context-type: application/json)

POST: http://localhost:8080/web_war/rest/autok/update (context-type: application/json)

Példa adatok:

  {
    "marka": "Ford",
    "model": "Focus",
    "rendszam": "JKL-789",
    "hengerurtartalom": 900,
    "tulajdonos": "Minta Bela",
    "gyartasEve": 2000,
    "muszakiVizsgaIdo": [
      2000,
      11,
      1
    ],
    "uzemanyag": "DIESEL"
  }
  
  {
    "marka": "Trabant",
    "model": "501",
    "rendszam": "ABC-123",
    "hengerurtartalom": 1200,
    "tulajdonos": "Mezei Virag",
    "gyartasEve": 1980,
    "muszakiVizsgaIdo": [
      2018,
      11,
      1
    ],
    "uzemanyag": "BENZIN"
  }
  
  {
    "marka": "Ferrari",
    "model": "F40",
    "rendszam": "CMD-789",
    "hengerurtartalom": 5000,
    "tulajdonos": "Teszt Elek",
    "gyartasEve": 2019,
    "muszakiVizsgaIdo": [
      2020,
      12,
      5
    ],
    "uzemanyag": "BENZIN"
  }
  
  {
    "marka": "Tesla",
    "model": "Model-S",
    "rendszam": "LSX-963",
    "hengerurtartalom": 5000,
    "tulajdonos": "Gazdag Gizi",
    "gyartasEve": 2019,
    "muszakiVizsgaIdo": [
      2020,
      12,
      5
    ],
    "uzemanyag": "ELEKTROMOS"
  }
]
