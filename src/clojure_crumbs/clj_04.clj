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

; shorthand defn

(defn my-fn-2
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
(def ^:private a-private-var 42)

; (caret ^ defines metadata)

; defn- defines a private function
(defn- my-private-fn
  [& args]
  (apply + args))

(my-private-fn 2 3 4)


; ===============
; Multi-functions
; ===============

; (think overloaded methods)

; TODO

; ===================
; Function conditions
; ===================

; TODO


;
