Parquimetro
Api para gerenciamento de consumo de eletrico nas residencias, de acordo com o número de pessoas que residêm na casa e também o cadastramento dos eletrodomesticos.

﻿

Address
Gerenciamento de endereços

﻿

POST
Criar endereço
http://localhost:8080/address
﻿

Body
raw (json)
json
{
    "street": "rua",
    "number": "723",
    "neighborhood": "bairro",
    "city": "SP",
    "state": "SPSP",
    "complement": "não tem"
}
PUT
Edit Address
http://localhost:8080/address/1
﻿

Body
raw (json)
json
{
    "street": "avenida",
    "number": "723",
    "neighborhood": "bairro",
    "city": "SP",
    "state": "batatinha",
    "complement": "não tem"
}
GET
Find All
http://localhost:8080/address
﻿

GET
Find By Id
http://localhost:8080/address/1
﻿

DELETE
Delete Address
http://localhost:8080/address/1
﻿

Vehicle
Gerenciamento de endereços

﻿

POST
Create Vehicle
http://localhost:8080/address
﻿

Body
raw (json)
json
{
    "street": "rua",
    "number": "723",
    "neighborhood": "bairro",
    "city": "SP",
    "state": "SPSP",
    "complement": "não tem"
}
PUT
Edit Vehicle
http://localhost:8080/address/1
﻿

Body
raw (json)
json
{
    "street": "avenida",
    "number": "723",
    "neighborhood": "bairro",
    "city": "SP",
    "state": "batatinha",
    "complement": "não tem"
}
GET
Find by user id
http://localhost:8080/address
﻿

GET
Find By vehicle Id
http://localhost:8080/address/1
﻿

DELETE
Delete Vehicle
http://localhost:8080/address/1
﻿

Users
﻿

POST
Criar usuario
http://localhost:8080/users
﻿

Body
raw (json)
json
{
    "street": "rua",
    "number": "723",
    "neighborhood": "bairro",
    "city": "SP",
    "state": "SPSP",
    "complement": "não tem"
}
GET
Find All
http://localhost:8080/users
﻿

GET
Find By Id
http://localhost:8080/address/1
﻿

DELETE
Delete User
http://localhost:8080/address/1
﻿

PUT
Edit User
http://localhost:8080/address/1
﻿

Body
raw (json)
json
{
    "street": "avenida",
    "number": "723",
    "neighborhood": "bairro",
    "city": "SP",
    "state": "batatinha",
    "complement": "não tem"
}
PaymentInformation
﻿

POST
Create Payment Information
http://localhost:8080/paymentInformation
﻿

Body
raw (json)
json
{
    "paymentType": "DEBITO"
}
GET
Find By user Id
http://localhost:8080/address/1
﻿

DELETE
Delete Payment Information
http://localhost:8080/address/1
﻿

PUT
Edit PaymentInformation
http://localhost:8080/address/1
﻿

Body
raw (json)
json
{
    "street": "avenida",
    "number": "723",
    "neighborhood": "bairro",
    "city": "SP",
    "state": "batatinha",
    "complement": "não tem"
}
Price
utilizado para criar o valor base de calculo para pagamento.

﻿

POST
create new price
http://localhost:8080/security/price?price=15.90
﻿

Query Params
price
15.90
GET
get current price
http://localhost:8080/security/price
﻿

ServiceOrder
﻿

POST
Save Service Order
http://localhost:8080/serviceOrder
﻿

Body
raw (json)
json
{
    "isFixedTime": true,
    "startTime": "2020-12-31T15:53:16",
    "endTime": "2020-12-31T17:30:16",
    "userId": 1
}
GET
Find by user id Copy
http://localhost:8080/address
﻿

PUT
terminate ticket
http://localhost:8080/address/1
﻿

Body
raw (json)
json
{
    "street": "avenida",
    "number": "723",
    "neighborhood": "bairro",
    "city": "SP",
    "state": "batatinha",
    "complement": "não tem"
}
DELETE
delete orderService
http://localhost:8080/serviceOrder/1
﻿
