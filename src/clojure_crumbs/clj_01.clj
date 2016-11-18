; Scalar data types
(ns clojure-crumbs.clj-01)

; function call
(+ 1 1)

; functions are more flexible than operators
(+ 1 2 3 4)
(* 1 2 3 4)

; (clojure.repl/doc +)
; (doc +)

; (source +)

; ========================
; DATA TYPES: SCALAR TYPES
; ========================

; Long, BigInt
42
(class 42)
(class 4200000000000000000)
(class 42000000000000000000)

(+ 1 2 3 4)
(- 15 2 3)
(* 5 2 3)
(/ 24 2 3)
(inc 5)
(dec 5)
(min 2 3 4 5)
(max 2 3 4 5)
(== 2 3)
(= 2 3)
(< 2 3)
(<= 3 3)
(>= 3 3)
(> 3 3)
(zero? 2)
(pos? -2)
(neg? -2)

; approximate decimal: Double, BigDecimal
3.14
(class 3.14)
3.1415926535897932384626
(class 3.1415926535897932384626)
3.1415926535897932384626M
(class 3.1415926535897932384626M)

; rational
22/7
(class 22/7)

; compare:
(/ 2   3)
(/ 2.0 3)

; char
\A
(class \A)

; string
"Some nice string"
(class "A nice string")

; boolean
true
false
(class true)

; no value
nil
(class nil)

;
