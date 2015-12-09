(ns address-book.core-spec
  (:require-macros [speclj.core :refer [describe it should should-not run-specs]])
  (:require [speclj.core]
            [address-book.core :as my-core]))

(describe "Truth"

          (it "is true"
              (should true))

          (it "is not false"
              (should-not false)))

(run-specs)
