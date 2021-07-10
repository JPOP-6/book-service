package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "get book by Id"
    request {
        method GET()
        headers {
            contentType(applicationJson())
        }
        url("/books/1")
    }
    response {
        status OK()
        headers {
            contentType(applicationJson())
        }
        body(file("getBookByIdResponse.json"))
    }
}