
function implicitVariableDemo() {
    var implicit = 10
    console.log("implicit : " + implicit)
}
implicitVariableDemo()
console.log("implicit : " + implicit)

// function hoistingVariableDemo() {
//     if (true){
//         var x = 22
//     }
//     console.log("x : " + x)
// }
// hoistingVariableDemo()
// //console.log("x : " + x)
//
// function hoistingVariableDemo2() {
//     var x;
//     if (true){
//         x = 22;
//     }
//     console.log("x : " + x)
// }
// hoistingVariableDemo()
// //console.log("x : " + x)
//
//
// function captureExample() {
//     var lst = [1, 2, 3, 4];
//     var functions = [];
//     for (var i = 0; i < lst.length; i++) {
//         var number = lst[i];
//         functions.push(function () {
//             return number
//         });
//     }
//     for (let i = 0; i < functions.length; i++) {
//         let functionToCall = functions[i];
//         console.log(functionToCall())
//     }
// }
// captureExample()
// //console.log("x : " + x)
//
//
// function accumulation() {
//     var strings = ["one", "fish", "two", "fish"]
//     var lengths = strings.map(value => value.length)
//     console.log(lengths);
// }
// accumulation()