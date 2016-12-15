; Symbols, keywords

; =======
; Symbols
; =======

; Names of variables, functions, etc.

; Start with non-numeric char
; May contain alphanumeric and *, +, !, -, _, ', ?
'my-variable*name'!?
(class 'my-variable*name'!?)
;my-variable*name'!?

; predicates typically end with ?
empty?

; side-effecting functions usually end with !
'update!

; / separates namespace
'some-namespace/some-symbol

(symbol "my-variable*name'!?")
(symbol "my-ns" "my-var")
(symbol? 'my-var)
(symbol? 42)

; ========
; Keywords
; ========

; Internalized strings
; Used in place of enums, do not have to be defined

; start with a colon
:name
(class :name)

; idiomatic: kebab case
:first-name

; may be namespaced
:customer/last-name
:supplier/last-name
(namespace :last-name)
(namespace :supplier/last-name)

; default namespace via ::
::namespaced-from-the-local-ns
(namespace ::namespaced-from-the-local-ns)
; global var holding current namespace
*ns*

(keyword "my-ns" "my-keyword")
(keyword? :name)
(keyword? 42)



;
