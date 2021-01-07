# Integrador

Producer mensagens no Kafka
```
POST
http://localhost:8081/publish
Body/raw/JSON
{
    "id": 11,
    "name": "jefferson"
}
```

Producer mensagens no Kafka
```
GET
http://localhost:8081/01523040
Return
{
    "cep": "01523-040",
    "logradouro": "Via de Pedestre Três Pontas",
    "complemento": "",
    "bairro": "Cambuci",
    "localidade": "São Paulo",
    "uf": "SP",
    "ibge": "3550308",
    "gia": "1004",
    "ddd": "11",
    "siafi": "7107"
}
```
