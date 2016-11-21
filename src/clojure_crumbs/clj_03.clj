; Collection types
(ns clojure-crumbs.clj-03)

; ============================
; DATA TYPES: COLLECTION TYPES
; ============================

; All collections are
; - IMMUTABLE (=> thread-safe)
; - PERSISTENT (= efficient creation of "modified" versions)
;   https://en.wikipedia.org/wiki/Persistent_data_structure
; - every col supports: count, conj, seq, first, etc.

; ====
; List
; ====

(1 2 3)
'(1 2 3)
(list 1 2 3)
(list 1, 2, 3)
(list)
(class (list 1 2 3))
; generic col functions
(count '(1 2 3))
(conj '(1 2 3) 4 5)
(seq '(1 2 3))
(first '(1 2 3))
(second '(1 2 3))
(next '(1 2 3))
(next '(3))
(rest '(1 2 3))
(rest '(3))
(last '(1 2 3))
(butlast '(1 2 3))
; stack-based access
(peek '(1 2 3))
(pop '(1 2 3))

; ======
; Vector
; ======

[1 2 3]
[]
(class [1 2 3])
; generic col functions
(count [1 2 3])
(conj [1 2 3] 4 5)
(seq [1 2 3])
; vector-based access
(first [1 2 3])
(get [1 2 3] 1)
(nth [1 2 3] 1)
(peek [1 2 3])
(rseq [1 2 3])
(first (rseq [1 2 3]))
(assoc [1 2 3] 1 4)
(assoc [1 2 3] 1 4 3 5 4 6)
(pop [1 2 3])
(subvec [1 2 3 4 5] 1 3)
(replace {2 4} [1 2 3 2])
; list -> vector
(vec '(1 2 3))
(vector '(1 2 3) '(4 5 6))
; vector -> list
(list [1 2 3])
(list* [1 2 3])
(into (list) [1 2 3])
(apply list [1 2 3])

; ===
; Map
; ===

{"key-1" "value-1" "key-2" "value-2" "key-3" "value-3"}
; idiomatic: use keywords as map keys
; (Clojure is dynamic)
{:key-1 "value-1" :key-2 42 :key-3 ["value-3-a" "value-3-b" "value-3-c"]}
; generic col functions
(count {:first-name "Joe", :last-name "Doe"})
(conj {:first-name "Joe", :last-name "Doe"} [:age 42])
(seq {:first-name "Joe", :last-name "Doe"})
; map-based access
(get {:first-name "Joe" :last-name "Doe"} :last-name)
(get {:first-name "Joe" :last-name "Doe"} :non-existent)
(get {:first-name "Joe" :last-name "Doe"} :non-existent :not-found)
({:first-name "Joe" :last-name "Doe"} :last-name)
;  idiomatic: use keyword as access function
(:last-name {:first-name "Joe" :last-name "Doe"})
(:non-existent {:first-name "Joe" :last-name "Doe"})
(:non-existent {:first-name "Joe" :last-name "Doe"} :not-found)
(contains? {:first-name "Joe" :last-name "Doe"} :first-name)
(find {:first-name "Joe" :last-name "Doe"} :first-name)
(first (find {:first-name "Joe" :last-name "Doe"} :first-name))
(second (find {:first-name "Joe" :last-name "Doe"} :first-name))
(val (find {:first-name "Joe" :last-name "Doe"} :first-name))
(keys {:first-name "Joe" :last-name "Doe"})
(vals {:first-name "Joe" :last-name "Doe"})
(assoc {:first-name "Joe" :last-name "Doe"} :age 42)
(dissoc {:first-name "Joe" :last-name "Doe" :age 42} :last-name)
(select-keys {:first-name "Joe" :last-name "Doe" :age 42} [:age :last-name])
(zipmap [:first-name :last-name] ["Joe" "Doe"])
; map -> vector of vectors
(vec {:first-name "Joe", :last-name "Doe"})
; vector (of vectors) -> map
(into {} [[:first-name "Joe"] [:last-name "Doe"]])

; ===
; Set
; ===

#{:val-1 42 "A string."}
; generic col functions
(count #{:val-1 42 "A string."})
(conj #{:val-1 42 "A string."} :added)
(seq #{:val-1 42 "A string."})
; set-based access
(contains? #{:a :b :c} :b)
(get #{:a :b :c} :b)
(get #{:a :b :c} :non-existent)
(get #{:a :b :c} :non-existent :not-found)
(#{:a :b :c} :b)
;  idiomatic: use keyword as access function
(:b #{:a :b :c})
(:non-existent #{:a :b :c})
(:non-existent #{:a :b :c} :not-found)
; set algebra
(clojure.set/union #{:a :b :c :d} #{:c :d :e :f})
(clojure.set/intersection #{:a :b :c :d} #{:c :d :e :f})
(clojure.set/difference #{:a :b :c :d} #{:c :d :e :f})
; set -> vector
(vec #{:val-1 42 "A string."})
; vector -> set
(set [:val-1 42 "A string."])


; Define a global variable
(def var1 "value1")
var1
(def var2 "value2")
var2
(def var2 "value3")
var2
var1

; Immutability
(def vec-1 [1 2 3])
vec-1
(def vec-2 (conj vec-1 4))
vec-2
vec-1

(def joe {:first-name "Joe" :last-name "Doe"})
joe
(def jane (assoc joe :first-name "Jane"))
jane
joe


; Functions are generic
(first '(1 2 3))
(first [1 2 3])
(first {:a 1 :b 2 :c 3})
(first #{1 2 3})
; even (!):
(first "abc")
; once you learn a function,
;  you'll be able to use it in any context, where it may make any sense

;
