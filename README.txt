Przed uruchomieniem aplikacji zainstalowaæ lokalnie baze postgres
Nastêpnie utworzyæ bazê:
CREATE USER pracownia WITH PASSWORD 'pracownia';
CREATE DATABASE organizer;
GRANT ALL PRIVILEGES ON DATABASE organizer TO pracownia;