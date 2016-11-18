; Symbols, keywords
(ns clojure-crumbs.clj-02)

; =======
; Symbols
; =======

; Names of variables, functions, etc.

; Start with non-numeric char
; May contain alphanumeric and *, +, !, -, _, ', ?
'my-variable*name'!?
my-variable*name'!?

; predicates typically end with ?
empty?

; side-effecting functions usually end with !
update!

; / separates namespace
some-namespace/some-symbol

; . qualifies class names
java.lang.Long
(class java.lang.Long)

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

; default namespace via ::
::namespaced-from-the-local-ns


;
