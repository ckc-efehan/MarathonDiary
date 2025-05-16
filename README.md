# Marathon-Tagebuch

Eine Webanwendung zur Verfolgung und Verwaltung von Marathon-Trainingseinheiten.

## Beschreibung

Das Marathon-Tagebuch ist eine Spring Boot-basierte Anwendung, die Läufern hilft, ihre Trainingseinheiten zu verfolgen und zu analysieren. Die Anwendung ermöglicht es Benutzern, Trainingsziele zu setzen und ihre tatsächlichen Leistungen zu vergleichen.

## Funktionen

- Erfassung von Trainingseinheiten mit Zielzeit und Zielkilometern
- Eingabe der tatsächlich gelaufenen Kilometer und Zeit
- Automatische Ermittlung, ob das Trainingsziel erreicht wurde
- Anzeige aller vergangenen Trainingseinheiten
- Bearbeiten und Löschen bestehender Einträge
- Sortierung der Einträge nach Datum (auf- und absteigend)
- Filterung nach erreichten und nicht erreichten Zielen
- Statistiken (z.B. gesamte gelaufene Kilometer)

## Technologien

- **Backend**: Java 21, Spring Boot 3.2.4
- **Datenbank**: PostgreSQL
- **API**: RESTful API
- **Frontend**: Separate Anwendung, die über CORS mit dem Backend kommuniziert
- **Build-Tool**: Gradle

## Installation und Start

### Voraussetzungen
- Java 21 JDK
- PostgreSQL Datenbank
- Gradle

### Schritte
1. Repository klonen:
   ```
   git clone https://github.com/yourusername/MarathonDiary.git
   cd MarathonDiary
   ```

2. Anwendung bauen:
   ```
   ./gradlew build
   ```

3. Anwendung starten:
   ```
   ./gradlew bootRun
   ```

Die Anwendung ist dann unter `http://localhost:8080` verfügbar.

## API-Endpunkte

- `GET /entries` - Alle Trainingseinträge abrufen
- `POST /entries` - Neuen Trainingseintrag erstellen
- `PUT /entries/{id}` - Trainingseintrag aktualisieren
- `DELETE /entries/{id}` - Trainingseintrag löschen

## Projektstruktur

```
src/main/java/de/htwberlin/webtech/MarathonTagebuch/
├── Controller/
│   └── TrainingentriesController.java
├── Entities/
│   └── TrainingentriesEntity.java
├── Interface/
│   └── TrainingentriesRepository.java
├── Service/
│   └── TrainingentriesService.java
└── MarathonTagebuchApplication.java
```

## Frontend

Das Frontend ist als separate Anwendung implementiert und unter folgenden URLs verfügbar:
- Produktion: https://marathondiary-frontend.onrender.com/
- Entwicklung: http://localhost:5173

## Lizenz

[MIT Lizenz](LICENSE)
