package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "get book by Id"
    request {
        method GET()
        url("/books/1")
    }
    response {
        status OK()
        body(file("getBookByIdResponse.json"))
    }
}