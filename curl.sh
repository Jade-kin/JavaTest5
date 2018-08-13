## login
curl -H "Content-Type:application/json" -X POST --data '{"name":"MARY","password":"SMITH"}' http://192.168.99.100:9090/customer/login
echo "----------------------------------------------------"

##getAllFilm
curl -d "page=1&pageSize=5" --request GET http://192.168.99.100:9090/film/getAllFilm
echo "----------------------------------------------------"

## addCustomer
curl -H "Content-Type: application/json" -X PUT --data '{"firstName":"Zhang","lastName":"san","email":"1234567@gmail.com","address":"1325 Fukuyama Street"}' http://192.168.99.100:9090/customer/addCustomer
echo "----------------------------------------------------"

## updateCustomer
curl -H "Content-Type: application/json" -X PUT --data '{"firstName":"Li","lastName":"si","email":"7654321@qq.com","address":"47 MySakila Drive"}' http://192.168.99.100:9090/customer/updateCustomer
echo "----------------------------------------------------"

## deleteCustomer
curl -X DELETE http://192.168.99.100:9090/customer/deleteCustomer