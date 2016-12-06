; Functions
(ns clojure-crumbs.clj-04)

; ====================
; Function definitions
; ====================

; Funtion fn defines new function
(def my-fn-1
  (fn [arg-1 arg-2]
    (+ arg-1 arg-2)))

(my-fn-1 1 2)

; Shorthand defn, more options

(defn my-fn-2
  "My function's documentation."
  [arg-1 arg-2]
  (+ arg-1 arg-2))

(my-fn-2 1 2)

; varargs

'(defn my-varargs-fn
   [arg-1 arg-2 & remaining-args]
   (* (+ arg-1 arg-2) (+ remaining-args)))
; apply

'(my-varargs-fn 2 3 4 5)

(+ 2 3)
'(+ [2 3])
(apply + [2 3])

; Function literal

(def my-literal-fn #(+ %1 %2))
(my-literal-fn 2 3)

; % .. %1
; %& .. & args

(def my-literal-rest-fn #(+ % (apply + %&)))
(my-literal-rest-fn 2 3 4 5)

; ==========================
; Making definitions private
; ==========================

(def a-public-var 42)
(def ^:private a-private-var 43)

; (caret ^ defines metadata)

; defn- defines a private function
(defn- my-private-fn
  [& args]
  (apply + args))

(my-private-fn 2 3 4)


; =====================
; Overloaded functions
; =====================

(defn my-overloaded-fn
  ([] 1)
  ([arg-1] (my-overloaded-fn 1 arg-1))
  ([arg-1 arg-2] (+ arg-1 arg-2)))

(my-overloaded-fn)
(my-overloaded-fn 4)
(my-overloaded-fn 4 5)


; ===================
; Function conditions
; ===================

(defn plus
  [a b]
  (+ a b))

(plus :name "string")
(plus -5 7)

(defn plus
  [a b]
  {:pre  [(number? a) (number? b) (pos? a) (neg? b)]
   :post [(pos? %)]}
  (+ a b))

(plus :name "string")
(plus -5 7)

; requiring keys in a map arg
(defn save-customer
  [values]
  {:pre [(map? values) (:first-name values) (:last-name values)]}
  (println values)
  :saved)

(save-customer "my customer")
(save-customer {})
(save-customer {:first-name "Joe"})
(save-customer {:first-name "Joe" :last-name "Doe"})

; you can restrict types on function input (and MUCH MORE than that!)
;  you are just not forced to do it everytime, only when it makes sense
;  => Clojure is practical


;
