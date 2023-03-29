class Gradina:
    def check(self, A, B):
        suma = A + B
        return 'Y' if max(suma.count(ch) for ch in (suma)) <= len(suma) // 2 else 'N'