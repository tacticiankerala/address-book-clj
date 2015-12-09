(ns address-book.app-spec
  (:require [speclj.core :refer :all]
            [address-book.app :refer :all]))

(describe "Truth"

          (it "is true"
              (should true))

          (it "is not false"
              (should-not false)))

(run-specs)
