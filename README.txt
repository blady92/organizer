Przed uruchomieniem aplikacji zainstalowa� lokalnie baze postgres
Nast�pnie utworzy� baz�:
CREATE USER pracownia WITH PASSWORD 'pracownia';
CREATE DATABASE organizer;
GRANT ALL PRIVILEGES ON DATABASE organizer TO pracownia;