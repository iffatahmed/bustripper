This tool queries ruter labs' API of bus lines in Oslo.
It's a command tool to find the first lines from the nearest bus stops after a search.

User flow:
1. User inputs a search string,
    Lysaker
2. which the program finds the related stopId using the API
    https://reisapi.ruter.no/Place/GetPlaces/Lysaker
(2190021)
3. then looks up the coming departures using
    https://reisapi.ruter.no/StopVisit/GetDepartures/2190021?datetime=2016-11-22T12:10:00
and prints
  line where-to of the first 10.

API documentation from https://reisapi.ruter.no/help or labs.ruter.no

Start it with # ./gradlew run -q
