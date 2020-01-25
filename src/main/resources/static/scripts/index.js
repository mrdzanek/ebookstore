
document.addEventListener("DOMContentReady" , () => {

});
function getProducts() {
    return fetch("/api/products")
    .then((response) => response.json())
    .catch((error) => console.log(error))
}

(() => {
    const productsListElement = document.querySelector('.products-list');

    getProducts().then((products) => {
        products
            .map(toHtml)
            .map(toElement)
            .map(initializeAddToBasket)
            .forEach(appendToProdList)
    });
})();
    console.log("Hello world!")
