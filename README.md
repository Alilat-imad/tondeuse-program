![Until Choice](https://user-images.githubusercontent.com/16879729/54986149-69d74780-4fb2-11e9-819d-14e3260f14a0.png)

# La Tondeuse

La société MowItNow a décidé de développer une tondeuse à gazon automatique, destinée aux surfaces rectangulaires.

La tondeuse peut être programmée pour parcourir l'intégralité de la surface. La position de la tondeuse est représentée
par une combinaison de coordonnées (x,y) et d'une lettre indiquant l'orientation selon la notation cardinale anglaise (
N,E,W,S). La pelouse est divisée en grille pour simplifier la navigation

# Aperçue d'exécution

Le fichier suivant est fourni en entrée :

5 5

1 2 N

GAGAGAGAA

3 3 E

AADAADADDA

On attend le résultat suivant (position finale des tondeuses) :

1 3 N

5 1 E

NB: Les données en entrée sont injectées sous forme de fichier.

# Envirement de developpement

- Spring boot 2.4.2
- Java 11
- Maven

# Prérequis

- Dans le fichier application.properties, modifier : spring.datasource.username & spring.datasource.password=admin avec
  vos accès de bdd et assurez vous que la BDD est lancé.

### Lancer l'application

Exécutez à partir du répertoire racine du projet. 

```sh
$ mvn clean install 
```
Cela générera un fichier jar dans le répertoire target/MowItNow-tondeuse-v0.1.jar.

Pour exécuter l'application Spring Boot à l'aide de Maven, exécutez la commande suivante à partir du répertoire target/

```sh
$ mvn spring-boot:run
```

Ou exécuter directement le jar

```sh
$ java -jar MowItNow-tondeuse-v0.1.jar
```

Une fois l'application lancée, nous devrions pouvoir le résultat du fichier traité.

License
----

MIT

**Merci !**
