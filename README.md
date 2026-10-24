# QuizFormes — Application Android de quiz

## 1. Présentation
QuizFormes est une application mobile Android conçue pour proposer un quiz interactif. L’utilisateur répond à des questions à choix multiples et consulte son score pendant ou à la fin du quiz.

> À vérifier et adapter selon la version réellement réalisée : catégories, nombre de questions, images, sauvegarde des résultats et autres fonctionnalités.

## 2. Objectifs
- Afficher des questions et plusieurs réponses possibles.
- Permettre à l’utilisateur de sélectionner une réponse.
- Indiquer si la réponse choisie est correcte ou incorrecte.
- Mettre à jour le score et la progression.
- Afficher un résultat final.

## 3. Technologies
- Android Studio : environnement de développement.
- Kotlin : langage de programmation, si utilisé dans le projet.
- XML : interfaces Android, si les écrans sont définis en XML.
- Android SDK : compilation et exécution de l’application.

Vérifier ces technologies dans le projet et supprimer toute technologie qui n’a pas été utilisée.

## 4. Fonctionnement
1. L’utilisateur ouvre l’application.
2. Une question et les réponses proposées s’affichent.
3. L’utilisateur sélectionne une réponse.
4. L’application vérifie la réponse et met à jour le score selon les règles implémentées.
5. L’utilisateur passe aux questions suivantes.
6. À la fin, l’application affiche le résultat final.

## 5. Structure du projet
La structure exacte dépend du projet. Un projet Android Studio contient généralement :
- `app/src/main/` : code source et ressources de l’application.
- `app/src/main/java/` ou `app/src/main/kotlin/` : fichiers Kotlin/Java.
- `app/src/main/res/` : layouts, images, icônes et autres ressources.
- `app/src/main/AndroidManifest.xml` : déclaration de l’application.
- `build.gradle` ou `build.gradle.kts` : configuration de compilation.

## 6. Lancement
1. Ouvrir Android Studio.
2. Sélectionner **Open** et choisir le dossier du projet.
3. Attendre la synchronisation Gradle.
4. Sélectionner un émulateur Android configuré ou un appareil compatible.
5. Cliquer sur **Run**.

## 7. Captures d’écran
Ajouter dans le dossier `captures/` des captures réelles de l’application :
- `01-question.png` : question affichée.
- `02-bonne-reponse.png` : traitement d’une réponse correcte.
- `03-mauvaise-reponse.png` : traitement d’une réponse incorrecte.
- `04-resultat-final.png` : écran de résultat final.

Ne conserver que les captures correspondant aux fonctionnalités effectivement présentes.

## 8. Tests à effectuer
- Vérifier l’affichage d’une question et de ses réponses.
- Vérifier la sélection d’une réponse.
- Vérifier le calcul du score pour une bonne réponse.
- Vérifier le comportement pour une mauvaise réponse.
- Vérifier le passage à la question suivante.
- Vérifier l’affichage du résultat final.
- Vérifier le comportement à la dernière question.

Compléter cette section avec les résultats des tests réellement effectués.

## 9. Auteurs
- Nom et prénom : [À compléter]
- Classe / groupe : [À compléter]
- Établissement : [À compléter]
- Encadrant(e) : [À compléter]
